package com.guojun.controller;


import com.guojun.domain.User;
import com.guojun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/selectByUser")
    public Result selectByUser(@RequestBody User u, HttpServletRequest request) {
        User user = userService.selectByUser(u);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "查询失败，请重新查询!";
        if(user != null){
            request.getSession().setAttribute("user",user); //把当前用户存储到session中
        }
        return new Result(code,user,msg);
    }

    @GetMapping("/{userName}")
    public Result selectByUserName(@PathVariable String userName) {
        User user = userService.selectByUserName(userName);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "查询失败，请重新查询!";
        return new Result(code,user,msg);
    }

    @PostMapping
    public Result add(@RequestBody User user) {
        boolean flag = userService.add(user);
        Integer code = flag ? Code.SAVE_OK : Code.SAVE_ERR;
        String msg = flag ? "" : "此邮箱已经被注册";
        return new Result(code,flag,msg);
    }


    @RequestMapping("/currentUser")
    @ResponseBody //把java对象转成json，也就是js对象
    public User currentUser(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        return user;
    }

}
