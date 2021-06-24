package com.heima.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author laofang
 * @description
 * @date 2021-06-13
 */
@Controller
@RequestMapping("/aa")//@RequestMapping作用于类之上，窄化路径
public class PathWriteTypeController {
    /**
     * 路径越精准，优先级越高
     * 精准路径下，任何后缀都匹配
     * eg:http://localhost:8080/aa/bb.do 也可以访问
     * @return
     */
//    @RequestMapping("/aa/bb")
    @RequestMapping("/bb")
    public String path1(){
        return "path1";
    }


    /**
     * 只能匹配aa开头的二级目录path
     * http://localhost:8080/aa/cc/dd 不能访问该接口
     * @return
     */
//    @RequestMapping("/aa/*")
    @RequestMapping("/*")
    public String path2(){
        return "path2";
    }


//    @RequestMapping("/aa/*.do")
    @RequestMapping("/*.do")
    public String path3(){
        return "path3";
    }


}
