package com.heima.web;

import com.heima.AccountService;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class AccountControlelr {
    //模拟web
    public static void main(String[] args) {
        //1.加载xml配置文件，创建ioc容器 ApplicationContext接口对应的实现采取的bean的加载方式是：立即加载
//        ApplicationContext ctx=
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//        //2.从ioc容器中获取bean对象
//        AccountService accountService1 = (AccountService) ctx.getBean("accountService1");
//        AccountService accountService2 = (AccountService) ctx.getBean("accountService1");
//        AccountService accountService3 = ctx.getBean("accountService1", AccountService.class);
//        System.out.println(accountService1);
//        System.out.println(accountService2);
//        System.out.println(accountService3);
//        System.out.println(accountService1==accountService2);
//        accountService1.add();
        //通过FileSystemXmlApplicationContext容器对象加载次磁盘绝对路径下的xml配置【了解】
//        ApplicationContext ctx=new FileSystemXmlApplicationContext("E:\\上课视频资料\\129\\day01-2-spring-ioc-xml\\src\\main\\resources\\applicationContext.xml");
//        AccountService accountService1 = (AccountService) ctx.getBean("accountService1");
//        accountService1.add();
        //BeanFacotory接口下的直接实现加载bean的方式是：延迟加载
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
        AccountService accountService1 = (AccountService) xmlBeanFactory.getBean("accountService1");
        accountService1.add();
    }
}
