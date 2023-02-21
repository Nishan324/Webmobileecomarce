package com.system.mobile_shopping.controller;
import com.system.mobile_shopping.pojo.ProductPojo;
import com.system.mobile_shopping.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;
    @GetMapping("dashboard")
    public String getDashboard() {
        return ("adminpanel");
    }

    @GetMapping("product")
    public String getProduct() {
        return ("adminproduct");
    }


    @GetMapping("/add")
    public String addPage(Model model){
        model.addAttribute("prod",new ProductPojo());
        return "addform";
    }


}
