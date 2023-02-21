package com.system.mobile_shopping.services;

import com.system.mobile_shopping.pojo.ProductPojo;

import java.io.IOException;

public interface ProductService {

    ProductPojo saveProduct(ProductPojo productPojo) throws IOException;
}
