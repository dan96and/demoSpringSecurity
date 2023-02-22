package com.example.demospringsecurity.controller;


import com.example.demospringsecurity.domain.User;
import com.example.demospringsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/new-user")
    public String newUser(@ModelAttribute User user){

        userService.registerUser(user);

        return "userRegistration";
    }

}
