package com.heima;

import com.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 测试restFull风格的路径书写
 * @author laofang
 * @description
 * @date 2021-06-15
 */
//@Controller
//@ResponseBody//注解打在类上，那么当前handler下的所有方法的返回值，都被序列化成字符串，响应的客户端
@RestController//等价于Controller+@ResponseBody
@RequestMapping("/user")
public class RestFullController {

    //localhost:8080/user/1
//    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    //等价于@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")
//    @ResponseBody
    public User getUserById(@PathVariable("id") Integer id){
        User user = new User();
        user.setId(id);
        user.setName("zhangsan");
        return user;
    }
    //post: url==>localhost:8080/user/2/lisi
    @PostMapping("/{id}/{name}")
//    @ResponseBody
    public User addUser(@PathVariable("id") Integer id,
                        @PathVariable("name") String name){
        User user = new User();
        user.setId(id);
        user.setName("zhangsan");
        return user;
    }

    /**
     * 更新使用put
     * @param id
     * @param name
     * @return
     */
    @PutMapping("/{id}/{name}")
//    @ResponseBody
    public User updateUser(@PathVariable("id") Integer id,
                        @PathVariable("name") String name){
        User user = new User();
        user.setId(id);
        user.setName("zhangsan");
        return user;
    }

    @DeleteMapping("/{id}")
//    @ResponseBody
    public User deleteUserById(@PathVariable("id") Integer id){
        User user = new User();
        user.setId(id);
        user.setName("zhangsan");
        return user;
    }



}
