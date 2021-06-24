package com.heima;

import com.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author laofang
 * @description
 * @date 2021-06-15
 */
@Controller
public class AjaxController {

    @RequestMapping("/test15")
    public void test15(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().write("juest test!");
    }

    @RequestMapping("/test16")
    @ResponseBody
    public String test16()  {
       return "test16";
    }
    //localhost:8080/test17?name=xx&id=xxx
    @RequestMapping("/test17")
    @ResponseBody
    public User test17(User user)  {
        System.out.println(user.toString());
       return user;
    }

    /**
     * 要求：
     * 需要将json格式的字符串转化成VO对象
     * 对象的序列化
     *      将vo对象转json字符串
     *     使用 @ResponseBody
     *
     * 对象的反序列化：将json字符串转vo对象
     *  使用@RequestBody
     * @param user
     * @return
     */
    @RequestMapping(value = "/test18",method = RequestMethod.POST)
    @ResponseBody
    public User test18(@RequestBody User user)  {
        System.out.println(user.toString());
       return user;
    }


}
