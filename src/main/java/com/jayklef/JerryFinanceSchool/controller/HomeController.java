package com.jayklef.JerryFinanceSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "/home"})
    public String displayHomePage(){
        //model.addAttribute("username","Jerry");
        return "home.html";
    }
}
