package com.scm.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String register(Model model) {
        UserForm userForm = new UserForm();
        // userForm.setName("Munwar Punhuani");
        // userForm.setEmail("munwar.punhuani@gmail.com");
        // userForm.setPassword("123");
        // userForm.setPhoneNumber("+923361392394");
        // userForm.setAbout("Write something about me here...");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // Processing register
    @RequestMapping(value = "do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        System.out.println("Processing Registration");
        // fetch form data
        System.out.println(userForm);
        // validate form data
        // TODO: NEXT VIDEO
        // save to database
        // convert userForm to user
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://www.youtube.com/watch?v=SAqi7zmW1fY&t=19055s")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://www.youtube.com/watch?v=SAqi7zmW1fY&t=19055s");

        Optional<User> savedUser = userService.saveUser(user);
        // message = "Registration Successful"
        System.out.println("User saved: "+savedUser);
        // redirect to login page
        return "redirect:/register";
    }

}
