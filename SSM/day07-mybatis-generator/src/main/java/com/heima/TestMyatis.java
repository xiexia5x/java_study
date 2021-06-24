package com.heima;

import com.heima.mapper.AccountMapper;
import com.heima.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author laofang
 * @description
 * @date 2021-06-18
 */
public class TestMyatis {
    public static void main(String[] args) throws IOException {
        //1.获取核心配置文件流对象
        InputStream resource = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.构建会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resource);
        //3.获取会话对象
        SqlSession sqlSession = sessionFactory.openSession();
        //4.获取代理对象
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account account = mapper.selectByPrimaryKey(1);
        System.out.println(account);
    }
}
