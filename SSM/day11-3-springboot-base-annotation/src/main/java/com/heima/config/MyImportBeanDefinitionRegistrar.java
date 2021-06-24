package com.heima.config;

import com.heima.pojo.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author laofang
 * @description
 * @date 2021-06-23
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        //创建bena的定义信息对象,bean的定义对象内涵盖了定义bean的一切信息
        AbstractBeanDefinition definition = BeanDefinitionBuilder.rootBeanDefinition(User.class).getBeanDefinition();
        //注册bena的定义对象
        registry.registerBeanDefinition("myUser",definition);
    }
}
