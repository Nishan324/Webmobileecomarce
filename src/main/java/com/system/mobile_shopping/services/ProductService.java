package com.system.mobile_shopping.services;

import com.system.mobile_shopping.entity.Product;
import com.system.mobile_shopping.pojo.ProductPojo;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    ProductPojo saveProduct(ProductPojo productPojo) throws IOException;

    List<Product> fetchAll();

    void deleteById(Integer id);

    Product fetchById(Integer id);



}
