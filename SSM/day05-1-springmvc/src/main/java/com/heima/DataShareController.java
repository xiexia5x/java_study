package com.heima;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

/**
 * 测试请求转发和重定向的数据共享
 * @author laofang
 * @description
 * @date 2021-06-15
 */
@Controller
public class DataShareController {

    /**
     * 测试原生api实现在请求转发时实现数据共享
     * @param request
     * @return
     */
    @RequestMapping("/test9")
    public String nativeForwardShare(HttpServletRequest request){
        request.setAttribute("msg","nativeForwardShare run....");
        return "show";
    }

    /**
     * 测试springmvc 请求转发时实现数据共享
     * @param
     * @return
     */
    @RequestMapping("/test10")
    public String springmvcForwardShare(Model model){
        //通过model在做请求转发时可将数据动态存入request对象下
        model.addAttribute("msg","springmvcForwardShare run....");
        //request.setAttribute("msg","springmvcForwardShare run....");
        return "show";
    }

    /**
     * 使用ModelAndView对象实现数据共享
     * @return
     */
    @RequestMapping("/test11")
    public ModelAndView springmvcForwardShare2(){
        ModelAndView mv = new ModelAndView();
        //设置数据
        mv.addObject("msg","springmvcForwardShare2 run....");
        //设置视图
        mv.setViewName("show");
        return mv;
    }


    //url:http://localhost:8080/test12?name=xxx&age=xx
    @RequestMapping("/test12")
    public String show(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name:"+name+",age:"+age);
        request.setAttribute("msg",name+":"+age);
        return "show";
    }


    /**
     * 使用model在重定向时实现数据共享
     * url:http://localhost:8080/test13?name=zhangsan&age=18
     * @return
     */
    @RequestMapping("/test13")
    public String modelRedirect(String name,Integer age,Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
//    public String modelRedirect(HttpServletRequest request){
        //model对象在请求重定向时，会自动将model中的数据拼接到重定向的url地址下
        //http://localhost:8080/test12?name=zhangsan&age=18
        return "redirect:/test12";
    }

    /**
     * http://localhost:8080/test14?name=zhangsan&age=18
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/test14")
    public ModelAndView modelRedirect2(String name, Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
//    public String modelRedirect(HttpServletRequest request){
        //model对象在请求重定向时，会自动将model中的数据拼接到重定向的url地址下
        //http://localhost:8080/test12?name=zhangsan&age=18
        mv.setViewName("redirect:/test12");
        return mv;
    }



}
