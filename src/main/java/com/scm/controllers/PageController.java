package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Controller");
        model.addAttribute("firstName", "Munwar Punhuani");
        model.addAttribute("occupation", "Software Engineer");
        model.addAttribute("address", "Karachi");
        return "home";
    }

    // about route
    @RequestMapping("/about")
    public String aboutPage(Model model) {
        System.out.println("About Page Loading");
        model.addAttribute("isLogin", false);
        return "about";
    }

    // services route
    @RequestMapping("services")
    public String servicesPage() {
        System.out.println("Services Page Loading");
        return "services";
    }

    // Contact us route
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    // login route
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // signup route
    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
