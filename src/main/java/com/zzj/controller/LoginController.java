package com.zzj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @类名 LoginController
 * @描述 TODO
 * @作者 yk
 * @日期 2018-8-16 11:37
 **/
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

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
    @RequestMapping(value = {"/userRegister"},method = { RequestMethod.POST }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String register(){

        return null;
    }
    @RequestMapping(value = {"/startLogin"},method = { RequestMethod.POST }, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String startLogin(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String ,Object> rsMap = new HashMap<>();
        if(null == username || null == password || "".equals(username) || "".equals(password)){
            rsMap.put("success",false);
            rsMap.put("msg","用户名或密码不能为空！");
            JSONObject jsonData = JSONObject.parseObject(JSON.toJSONString(rsMap));
            return jsonData.toJSONString();
        }
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("username",username);
        paramMap.put("password",password);
        Map<String,Object> serviceMap = loginService.stratLogin(paramMap);
        rsMap.put("success",serviceMap.get("success"));
        rsMap.put("msg",serviceMap.get("msg"));
        JSONObject jsonData = JSONObject.parseObject(JSON.toJSONString(rsMap));
        return jsonData.toJSONString();
    }
}
