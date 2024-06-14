package com.kk.spring_security_tut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/signin")
    public String signin(){
        return "signin";
    }

//    @GetMapping("/signout")
//    public String logoutpage(){
//        return "signout";
//    }

    @GetMapping("/signin_success")
    public String signinsuccess(){
        return "signin_success";
    }
}
