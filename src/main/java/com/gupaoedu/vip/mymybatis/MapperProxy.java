package com.gupaoedu.vip.mymybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 2020/5/15
 * Created by lijie
 */
public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterfaceName = method.getDeclaringClass().getName();
        String statementId = mapperInterfaceName + "." + method.getName();
        sqlSession.selectOne(statementId, args[0]);
        return null;
    }
}
