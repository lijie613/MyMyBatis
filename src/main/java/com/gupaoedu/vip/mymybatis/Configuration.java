package com.gupaoedu.vip.mymybatis;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * 2020/5/15
 * Created by lijie
 */
public class Configuration {
    public final static ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("sql");
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{type},
                new MapperProxy(sqlSession));
    }
}
