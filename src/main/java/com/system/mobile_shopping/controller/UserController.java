package com.system.mobile_shopping.controller;

import com.system.mobile_shopping.pojo.UserPojo;
import com.system.mobile_shopping.services.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserServices userServices;
    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "signup";
    }



    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo) {
        userServices.save(userPojo);
        return "redirect:/login";
    }
}
