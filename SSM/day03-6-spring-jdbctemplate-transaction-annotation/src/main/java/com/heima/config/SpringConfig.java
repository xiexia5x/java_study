package com.heima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.swing.tree.TreeNode;

/**
 * @author laofang
 * @description
 * @date 2021-06-12
 */
@Configuration
@ComponentScan(basePackages = "com.heima")
//    <context:property-placeholder location="classpath:jdbc.properties" file-encoding="UTF-8"/>
@PropertySource(value = "classpath:jdbc.properties")
@EnableAspectJAutoProxy//<aop:aspectj-autoproxy/>
@EnableTransactionManagement//开启事务注解驱动支持，等同于<tx:annotation-driven/>
public class SpringConfig {

    @Value("${jdbc.userName}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.driverClass}")
    private String driverClass;

    /**
     *     <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
     *         <property name="username" value="${jdbc.userName}"/>
     *         <property name="password" value="${jdbc.password}"/>
     *         <property name="url" value="${jdbc.url}"/>
     *         <property name="driverClassName" value="${jdbc.driverClass}"/>
     *     </bean>
     * @return
     */
    @Bean("dataSource")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClass);
        return  dataSource;
    }

    /**
     * <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
     *         <property name="dataSource" ref="dataSource"/>
     *     </bean>
     * @return
     */
    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    /**
     *   <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
     *         <property name="dataSource" ref="dataSource"/>
     *     </bean>
     * @return
     */
    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
