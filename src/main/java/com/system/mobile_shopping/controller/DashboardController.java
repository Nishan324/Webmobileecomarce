package com.system.mobile_shopping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view")
public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboard(){
        return "index";
    }
}
