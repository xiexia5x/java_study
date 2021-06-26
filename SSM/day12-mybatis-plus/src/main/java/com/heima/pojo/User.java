package com.heima.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author laofang
 * @description
 * @date 2021-06-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
//将pojo类与table进行绑定
@TableName(value = "tb_user")
public class User {
    //指定注解对应的属性 设置主键生成的策略 IdType.AUTO 使用数据库主键自增
    @TableId(value = "id",type=IdType.AUTO)
    private Long id;
    //mybatisplus默认自动开启驼峰映射
    private String userName;
    private String password;
    @TableField("t_name")
    private String name;
    private Integer age;
    private String email;
    //指定表中不存在该字段，在进行操作时，忽略该字段
    @TableField(exist = false)
    private String address;

    //User::getAge();===>获取字段名称：age===>反射获取字段对应的Field对象====》getAnnotation===>获取t_name
}

