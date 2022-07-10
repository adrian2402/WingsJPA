/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Victor Rosales
 */
@Controller

public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "Bienvenido a Thymeleaf");
        return "inicio";
    }
    @GetMapping("/login")
    public String login(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("titulo", "Bienvenido a Thymeleaf");
        return "login";
    }
    
    @GetMapping("/mantenimiento")
    public String index(Model model) {
        model.addAttribute("titulo", "Bienvenido a Thymeleaf");
        return "index";
    }
    

    
    
}
