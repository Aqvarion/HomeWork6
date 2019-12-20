package com.blackapple.hw.controller;

import com.blackapple.hw.model.UserDto;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, HttpServletResponse result){
        return "result";
    }
}
