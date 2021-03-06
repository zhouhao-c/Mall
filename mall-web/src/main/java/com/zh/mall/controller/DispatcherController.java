package com.zh.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/*
* 调度控制器
*
* */

@Controller
public class DispatcherController {
    @RequestMapping(value= {"/index", "", "/", "/index/"})
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/member")
    public String member(){
        return "member";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //session.removeAttribute("");
        session.invalidate();
        return "redirect:/login";
    }
}
