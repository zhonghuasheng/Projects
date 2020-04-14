package com.zhonghuasheng.musicstore.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.util.StringUtils;

public class BaseDao extends SqlSessionDaoSupport {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    protected String getSqlNameSpace(Class<?> c) {
        return StringUtils.concat(c.getInterfaces()[0], ".");
    }
}
