package com.heima.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义导入选择器
 * @author laofang
 * @description
 * @date 2021-06-23
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 实现组件的批量导入
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.heima.pojo.Account","com.heima.pojo.User"};
    }
}
