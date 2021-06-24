package com.heima.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author laofang
 * @description
 * @date 2021-06-13
 */
@Controller
@RequestMapping("/at")
public class ReqeustMappingAttiController {

    /**
     * 测试value或者path属性
     * 相同的处理器方法可以被不同的url地址访问
     * value和path属性等价
     * @return
     */
    //localhost:8080/at/path1
    //localhost:8080/at/path2
    @RequestMapping(value = {"path1","path2"})
    public String attri1(){
        return "path1";
    }


    /**
     * 只允许使用post请求访问该接口
     * 通过method指定当前接口只允许哪些请求方式进行请求
     * @return
     */
//    @RequestMapping(value = "/method",method ={RequestMethod.GET,RequestMethod.POST} )
    @RequestMapping(value = "/method",method =RequestMethod.GET )
    public String attri2(){
        return "path1";
    }

    /**
     * 通过params属性限制请求必须携带指定的参数
     * @return
     */
    @RequestMapping(value = "/params",params = {"name","age"})
    public String atti3(){
        return "hello";
    }


    /**
     * headers属性限制http请求头中必须携带指定的key
     * @return
     */
    @RequestMapping(value = "/headers",headers = {"token","author"})
    public String atti4(){
        return "path2";
    }

}
