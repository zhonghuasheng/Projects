package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.common.CodeMsg;
import com.zhonghuasheng.seckill.common.Result;
import com.zhonghuasheng.seckill.service.SeckillUserService;
import com.zhonghuasheng.seckill.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private SeckillUserService seckillUserService;

    private Logger log = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/login")
    @ResponseBody
    public Result<Boolean> login(HttpServletResponse response, @Valid LoginVo loginVo) {
        CodeMsg cm = seckillUserService.login(response, loginVo);
        return Result.success(true);
    }
}
