package com.heima;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heima.dao.AccountDao;
import com.heima.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-16
 */
public class TestNativeMybatis {
    @Test
    public void test1() throws IOException {
       //1.获取核心配置文件流对象
        InputStream resource = Resources.getResourceAsStream("mybatisConfig.xml.bak");
        //2.构建会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resource);
        //3.获取会话对象
        SqlSession sqlSession = sessionFactory.openSession();
        //4.获取代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        //设置当前页的页数和页的大小
        PageHelper.startPage(5,2);
        //返回当前页数据
        List<Account> all = mapper.findAll();
        //获取分页详情
        PageInfo<Account> pageInfo = new PageInfo<>(all);
        //获取当前页
        int pageNum = pageInfo.getPageNum();
        //获取查询每页大小
        int pageSize = pageInfo.getPageSize();
        //获取当前页的记录数
        int size = pageInfo.getSize();
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取总页数
        int pages = pageInfo.getPages();
        //下一页
        int nextPage = pageInfo.getNextPage();
        //获取上一页
        int prePage = pageInfo.getPrePage();
        //获取当前页的数据集合
        List<Account> list = pageInfo.getList();

        System.out.println(all);
    }
}
