package com.gupaoedu.vip;

import com.gupaoedu.vip.dao.BlogMapper;
import com.gupaoedu.vip.mymybatis.Configuration;
import com.gupaoedu.vip.mymybatis.Executor;
import com.gupaoedu.vip.mymybatis.SqlSession;

/**
 * 2020/5/15
 * Created by lijie
 */
public class MybatisBoot {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new Configuration(), new Executor());
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        mapper.selectBlogById(1);
    }
}
