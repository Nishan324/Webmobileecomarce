package com.system.mobile_shopping.controller;
import com.system.mobile_shopping.entity.Product;
import com.system.mobile_shopping.pojo.ProductPojo;
import com.system.mobile_shopping.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;

    @GetMapping("/dashboard")
    public String getDashboard() {
        return "adminpanel";
    }

    @GetMapping("/product")
    public String getProduct() {
        return ("adminproduct");
    }



    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("prod", new ProductPojo());
        return "addform";
    }

//    @GetMapping("/product/{id}")
//    public String fetchById(@PathVariable Integer id, Model model){
//        Product product= productService.fetchById(id);
//        model.addAttribute("products", new ProductPojo(product));
////        model.addAttribute("productdata", productService.fetchById(principal.getName())
//        model.addAttribute("product", product);
//        return "deleteproduct";
//    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        productService.deleteById(id);
        return "redirect:/prod/getProduct";
    }
}


//    @GetMapping("/price")
//    public String getPricePage(Model model){
////        model.addAttribute("priceTab",new Admin());
//        List<Product> product = ProductService.fetchALL();
//
//
//        model.addAttribute("priceTable", Product.stream().map(admin ->
//                Product.builder()
//                        .id(product.getid())
//                        .duration(product.getDuration())
//                        .price(product.getPrice())
//                        .build()
//
//        ));
//        return "User/price";
//    }
//
//
//}
