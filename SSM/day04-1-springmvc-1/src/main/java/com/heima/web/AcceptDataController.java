package com.heima.web;

import com.heima.vo.CollectionVo;
import com.heima.vo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * @author laofang
 * @description
 * @date 2021-06-13
 */
@Controller
@RequestMapping("/acc")
public class AcceptDataController {

    /**
     * 测试基本类型和String的接收
     * url:http://localhost:8080/acc/basicType?name=laofagn&age=18
     * 注意事项：
     *  请求参数名称与方法的形参名称一致即可
     * @return
     */
    @RequestMapping("/basicType")
    public String acc1(@RequestParam("userName") String name, String age){
        System.out.println("name:"+name+"---age:"+age);
        return "path1";
    }

    /**
     * url:http://localhost:8080/acc/diff?userName=laofagn&userAge=18
     * @RequestParam
     *  作用：请求参数名称与方法中形参名称不一致时可以使用
     *      value：指定请求参数的名称，
     *      required:
     *          true:请求参数必须携带指定的参数，否则报错
     *          false:非必须 一般配置defaultValue属性一块使用
     *          defaultValue：设置默认值
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/diff")
    public String acc7(@RequestParam(value = "userName",required = false,defaultValue ="李彬" ) String name,
                       @RequestParam(value = "userAge",required = false,defaultValue = "20") String age){
        System.out.println("name:"+name+"---age:"+age);
        return "path1";
    }

    /**
     * 测试接收vo数据类型
     * 注意事项：
     *  请求参数名称与vo中属性名称一致即可
     * @return
     */
    @RequestMapping("/vo")
    public String acc2(User user){
        System.out.println(user);
        return "path1";
    }

    /**
     * 测试接收数组
     * 注意事项：
     *  请求参数名称与方法形参中数组对应的变量名称一致即可
     * @return
     */
    @RequestMapping("/array")
    public String acc3(String[] names){
        System.out.println(Arrays.toString(names));
        return "path1";
    }


    /**
     * 测试发送基本类型、string 以list集合封装
     * @param vo
     * @return
     */
    @RequestMapping("/list")
    public String acc4(CollectionVo vo){
        System.out.println(vo);
        return "path2";
    }


    /**
     * @DateTimeFormat(pattern = "yyyy-MM-dd")
     * 将字符串转换成Date类型
     * @param birthday
     * @return
     */
//    @RequestMapping("/date")
//    public String acc5(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday){
//        System.out.println(birthday);
//        return "path2";
//    }
    @RequestMapping("/date")
    public String acc5(Date birthday){
        System.out.println(birthday);
        return "path2";
    }


    /**
     * 编码过滤器
     * @return
     */
    @RequestMapping("/encode")
    public String acc6(String name, HttpServletRequest request){
        System.out.println(name);
        request.setAttribute("name",name);
        return "show";
    }

    /**
     * 测试获取请求头中的数据
     * @param token
     * @return
     */
    @RequestMapping("/getHeadData")
    public String acc8(@RequestHeader("token") String token){
        System.out.println(token);
        return "path3";
    }

    /**
     * @CookieValue获取请求中携带的cookie对应的value值
     * @param cookieValue
     * @return
     */
    @RequestMapping("/getCookieData")
    public String acc9(@CookieValue("JSESSIONID") String cookieValue){
        System.out.println(cookieValue);
        return "path3";
    }

}
