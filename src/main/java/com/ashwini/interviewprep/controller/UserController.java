package com.ashwini.interviewprep.controller;

import com.ashwini.interviewprep.entity.User;
import com.ashwini.interviewprep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);

        return "success";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
    @PostMapping("/checkLogin")
    public String checkLogin(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session) {

        User user =
                userRepository.findByEmailAndPassword(
                        email,
                        password);

        if(user != null) {

            session.setAttribute("email",
                    user.getEmail());

            session.setAttribute("name",
                    user.getName());

            return "dashboard";
        }

        return "login";
    }}
