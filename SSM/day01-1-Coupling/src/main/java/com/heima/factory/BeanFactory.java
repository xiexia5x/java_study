package com.heima.factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author laofang
 * @description
 * @date 2021-06-09
 */
public class BeanFactory {
    //存储key-->string类的全限定名称
    private static Map<String,String>  instanceDefination=new HashMap<>();
    //存储key--->instance
    private static Map<String,Object> instanceCache=new HashMap<>();


    /**
     * 通过io加载配置文件，因为io非常耗时，通过静态代码块做到只加载一次
     * 加载的数据存放到map集合下即可
     */
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("bean");
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            //获取类的全限定名称
            String className = bundle.getString(key);
            instanceDefination.put(key,className);
            //直接创建对象 立即加载
        }
    }

    /**
     * 懒加载
     * @param key
     * @return
     */
    public static Object getInstance(String key){
        //现在对象缓存中查询是否存在实例对象
        Object instance = instanceCache.get(key);
        if (instance==null) {
            //根据key获取类的全限定名称
            String className = instanceDefination.get(key);
            //通过反射获取对象
            try {
                instance = Class.forName(className).newInstance();
                instanceCache.put(key,instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


}
