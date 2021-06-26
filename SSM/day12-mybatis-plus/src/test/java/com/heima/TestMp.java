package com.heima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heima.mapper.UserMapper;
import com.heima.pojo.User;
import static org.junit.jupiter.api.Assertions.*;

import com.heima.service.UserService;
import com.sun.media.sound.SoftTuning;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author laofang
 * @description
 * @date 2021-06-25
 */
@SpringBootTest
public class TestMp {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void test1()  {
        User user = userMapper.selectById(1l);
        System.out.println(user);
        assertEquals("赵一伤",user.getUserName(),"查询有误");
    }

    /**
     * 测试add
     */
    @Test
    public void test2()  {
        User user = new User().setName("赵丽颖").setAge(35).setPassword("1234").setUserName("美女666").setEmail("4444@qq.com");
        int count = userMapper.insert(user);
        //自动主键回填
        System.out.println(user);
        assertEquals(1,count,"插入失败");
    }

    /**
     * 根据id删除
     */
    @Test
    public void test3()  {
        int count = userMapper.deleteById(1408258721888399362l);
        assertEquals(1,count,"删除失败");
    }

    /**
     * 根据id集合批量删除
     */
    @Test
    public void test4()  {
        int count = userMapper.deleteBatchIds(Arrays.asList(1408258721888399361l,1408254172524032001l));
        assertEquals(2,count,"删除失败");
    }


    /**
     * 根据map条件删除集合批量删除
     * map key：table中字段名称 value：查询指定字段等于该值的数据
     */
    @Test
    public void test5()  {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_name","赵二伤");
        map.put("age",25);
        int count = userMapper.deleteByMap(map);
        assertEquals(1,count,"删除失败");
    }

    /**
     * 测试根据id更新
     */
    @Test
    public void test6()  {
        User user = new User().setId(1l).setName("赵丽颖").setAge(35).setPassword("1234").setUserName("美女666").setEmail("4444@qq.com");
        int count = userMapper.updateById(user);
        assertEquals(1,count,"更新失败");
    }

    /**
     * 测试分页查询
     */
    @Test
    public void test7()  {
       //创建分页对象
        IPage<User> page = new Page<>();
        //设置当前页
        page.setCurrent(2);
        //设置分页的大小
        page.setSize(4);
        IPage<User> page2 = userMapper.selectPage(page, null);
        //数据直接在page获取即可
        userMapper.selectPage(page, null);
        System.out.println(page==page2);
        //获取查询记录数
        List<User> records = page2.getRecords();
        System.out.println(records);
        //获取总页数
        long pages = page2.getPages();
        System.out.println(pages);
        //分页大小
        long size = page2.getSize();
        System.out.println(size);
        long current = page2.getCurrent();
        //获取当前页码
        System.out.println(current);
        //获取总记录数
        long total = page2.getTotal();
        System.out.println(total);
    }

    /**
     * 根据QueryWrapper条件查询
     */
    @Test
    public void test8()  {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name","赵")
                .in("age",Arrays.asList(29,39))
                .orderByDesc("age","id");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
        assertEquals(4,users.size(),"查询数据错误");

    }

    /**
     * or添加查询
     */
    @Test
    public void test9()  {
        //select * from tb_user where (age=?) or (name in {?,?,?} and id between ? and ?)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //or方法用于使用or关键字关联左右的条件
        wrapper.eq("age",20)
                .or(false)
                 .in("t_name",Arrays.asList("周五输","郑七灭","王八衰"))
                 .between("id",6l,10l);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);

    }


    /**
     * like 模糊搜索
     */
    @Test
    public void test10()  {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //底层自动给赵添加通配符===》 %赵%
//        wrapper.like("user_name","赵")
        //底层自动给伤添加通配符===》 %伤
//        wrapper.likeLeft("user_name","伤");
        //底层自动给赵添加通配符===》 赵%
        wrapper.likeRight("user_name","赵");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /**
     * 排序查询
     *
     */
    @Test
    public void test11()  {
        //SELECT id,user_name FROM tb_user ORDER BY age DESC,id ASC
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","user_name")
                .orderByDesc("age")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /**
     * lamdaQueryWrap
     *        使用QueryWrapper缺点：
     *        1.table的列名硬编码写入，不方便维护
     *        2.开发不方便，容器写错；
     *         wrapper.eq("age",20)
     *                 .or(false)
     *                  .in("t_name",Arrays.asList("周五输","郑七灭","王八衰"))
     *                  .between("id",6l,10l);
     */
    @Test
    public void test12()  {
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(User::getAge,20)
                    .or()
                    .in(User::getName,Arrays.asList("周五输","郑七灭","王八衰"))
                     .between(User::getId,6l,10l) ;
        List<User> users = userMapper.selectList(lambdaQuery);
        System.out.println(users);
    }

    /**
     * 根据条件Wrapper删除
     */
    @Test
    public void test13()  {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.in(User::getId,Arrays.asList(1,2,3,4))
                .gt(User::getAge,20);
        int count = userMapper.delete(wrapper);
        assertEquals(2,count,"删除错误");

    }

    /**
     * 条件更新
     */
    @Test
    public void test14()  {
       //1.创建更新后的数据对象
        User user = new User().setUserName("龙哥邪魅一笑").setAge(22);
        //2.创建更新条件
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.in(User::getId,Arrays.asList(6,7));

        int count = userMapper.update(user, wrapper);
        assertEquals(2,count,"更新错误");

    }
    /**
     * 条件更新
     */
    @Test
    public void test15()  {
        //LambdaUpdateWrapper内部维护了更新的数据和更新的条件
        LambdaUpdateWrapper<User> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.in(User::getId,Arrays.asList(15,16))
                      .set(User::getUserName,"龙哥邪魅一笑")
                      .set(User::getAge,22) ;
        int count = userMapper.update(null, updateWrapper);
        assertEquals(2,count,"更新错误");

    }

    /**
     * 测试通用service实现
     */
    @Test
    public void test16()  {
        User user = userService.getById(2l);
        System.out.println(user);
    }

}
