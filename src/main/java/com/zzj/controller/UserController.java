package com.zzj.controller;/**
 * @Auther: yk
 * @Date: 2018-8-15 16:04
 * @Description:
 */

import com.zzj.model.User;
import com.zzj.service.UserService;
import com.zzj.util.DateUtils;
import com.zzj.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@className UserController
 *@Description TODO
 *@Author yk
 *@Date 2018-8-15 16:04
 *@Version 1.0
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRegip(Tools.getIpAddress(request));
        user.setRegtime(DateUtils.getNowTimestamp());
        user.setRole("0");
        user.setStatus(0);
        int rs = 0;
        try {
            rs = userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            rs=0;
        }
        return rs;
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }

    @RequestMapping("/test")
    public String test(){

        return "test";
    }


}


