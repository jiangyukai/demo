package com.zzj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @类名 LoginController
 * @描述 TODO
 * @作者 yk
 * @日期 2018-8-16 11:37
 **/
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    /**
     * @名称 login
     * @描述 //登录页面调转
     * @参数 []
     * @返回值 java.lang.String
     * @作者 yk
     * @时间 2018-8-16 11:39
     */
    @RequestMapping("/userLogin")
    public String login(){
        return "login";
    }
    @RequestMapping("/userRegister")
    @ResponseBody
    public String register(){

        return null;
    }
}
