package com.system.mobile_shopping.pojo;

import com.system.mobile_shopping.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPojo {
    private Integer id;

    private String name;
    private String price;

    private String message;


    private MultipartFile image;

    public ProductPojo(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.message = product.getMessage();
    }
    }