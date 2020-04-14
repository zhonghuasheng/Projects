package com.zhonghuasheng.seckill.service;

import com.zhonghuasheng.seckill.common.CodeMsg;
import com.zhonghuasheng.seckill.dao.SecKillUserDao;
import com.zhonghuasheng.seckill.domain.SecKillUser;
import com.zhonghuasheng.seckill.exceptioin.GlobalException;
import com.zhonghuasheng.seckill.redis.RedisService;
import com.zhonghuasheng.seckill.redis.SeckillUserKey;
import com.zhonghuasheng.seckill.util.MD5Util;
import com.zhonghuasheng.seckill.util.UUIDUtil;
import com.zhonghuasheng.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class SeckillUserService {

    public static final String COOKIE_NAME_TOKEN = "token";
    @Autowired
    private SecKillUserDao secKillUserDao;
    @Autowired
    private RedisService redisService;

    public SecKillUser getById(long id) {
        return secKillUserDao.getById(id);
    }

    public CodeMsg login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SESSION_ERROR);
        }
        // 判断手机号是否存在
        SecKillUser user = getById(Long.parseLong(loginVo.getMobile()));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        // 验证密码
        String dbPass = user.getPassword();
        String dbSalt = user.getSalt();
        String formPass2DbPass = MD5Util.formPass2DbPass(loginVo.getPassword(), dbSalt);
        if (!formPass2DbPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        // 生成cookie
        String token = UUIDUtil.uuid();
        addCookie(response, token, user);

        return CodeMsg.SUCCESS;
    }

    private void addCookie(HttpServletResponse response, String token, SecKillUser user) {
        redisService.set(SeckillUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(SeckillUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public SecKillUser getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        SecKillUser user = redisService.get(SeckillUserKey.token, token, SecKillUser.class);
        if (user != null) {
            addCookie(response, token, user);
        }

        return user;
    }
}
