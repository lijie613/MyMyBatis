package com.gupaoedu.vip.mymybatis;

/**
 * 2020/5/15
 * Created by lijie
 */
public class SqlSession {
    private Configuration configuration;
    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId, Object parameter) {
//        String sql = statementId; // 先用statementId 代替sql
        String sql = Configuration.sqlMappings.getString(statementId);
        if (sql != null && !"".equals(sql)) {
            return executor.query(sql, parameter);
        }
        return null;
    }

    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }
}
