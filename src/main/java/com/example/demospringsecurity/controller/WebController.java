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

    @GetMapping("/login")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/new-user")
    public String newUser(@ModelAttribute User user, Model model) {
        if(userService.registerUser(user)){
            model.addAttribute("messageRegister", "Usuario registrado correctamente");
        }else{
            model.addAttribute("messageRegister", "NO se ha podido registrar el usuario. Intentelo de nuevo mas tarde.");
        }

        return "ok";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/home/screenUser")
    public String screenUser() {
        return "screenUser";
    }

    @GetMapping("/home/screenAdmin")
    public String screenAdmin(){
        return("screenAdmin");
    }

}
