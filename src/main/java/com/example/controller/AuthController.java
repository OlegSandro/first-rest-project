package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class was created for testing of Tomcat's successful launch
 */
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    private AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String welcome() {
        System.out.println("GET /");
        return String.valueOf(counter.incrementAndGet());
    }

    @GetMapping("/login")
    public String loginGet() {
        System.out.println("GET /login");
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username, @RequestParam String password) {
        System.out.println("POST /login");
        List<User> users = userService.list();
        for(User user : users)
            if(user.getLogin().equals(username))
                if(user.getPassword().equals(password))
                    return "redirect:/welcome";
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String registerGet() {
        System.out.println("GET /reg");
        return "reg";
    }

    @PostMapping("/reg")
    public String registerPost(@RequestParam String username, @RequestParam String password) {
        System.out.println("POST /reg");
        User user = new User();
        user.setLogin(username);
        user.setPassword(password);
        user.setId_role(2);
        userService.save(user);
        return "redirect:/welcome";
    }

    @GetMapping(value = {"/home", "/welcome"})
    public String home() {
        System.out.println("GET /welcome");
        return "welcome";
    }
}
