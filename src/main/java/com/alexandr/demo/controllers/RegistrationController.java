package com.alexandr.demo.controllers;

import com.alexandr.demo.domain.Role;

import com.alexandr.demo.domain.User;

import com.alexandr.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;
    private User user;

    @GetMapping("/registration")
    public String registrationPage(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model){
       User userFromDb = userRepo.findByUsername(user.getUsername());

       if (userFromDb!= null){
           model.put("message", "user exists");
           return "/registration";
       }
       user.setEnabled(true);
       user.setRole(Collections.singleton(Role.ADMIN));
       userRepo.save(user);
       return "redirect:/login";
    }
}
