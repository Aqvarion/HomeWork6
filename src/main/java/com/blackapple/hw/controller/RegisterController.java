package com.blackapple.hw.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class RegisterController {
    @GetMapping("/registerform")
    public String reg(Model model){
        return "registerform";
    }
}
