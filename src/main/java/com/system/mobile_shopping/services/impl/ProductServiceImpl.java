package com.system.mobile_shopping.services.impl;


import com.system.mobile_shopping.entity.Product;
import com.system.mobile_shopping.pojo.ProductPojo;
import com.system.mobile_shopping.repo.ProductRepo;
import com.system.mobile_shopping.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/images";
    @Override
    public ProductPojo saveProduct(ProductPojo productPojo) throws IOException {
        Product product = new Product();
        if (productPojo.getId() != null){
            product.setId(productPojo.getId());
        }
        product.setName(productPojo.getName());
        product.setPrice(productPojo.getPrice());
        product.setMessage(productPojo.getMessage());

        if(productPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productPojo.getImage().getOriginalFilename());
            fileNames.append(productPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, productPojo.getImage().getBytes());
            product.setImage(productPojo.getImage().getOriginalFilename());

        }
        productRepo.save(product);
        return new ProductPojo(product);
    }
    public List<Product> listMapping(List<Product> list){
        Stream<Product> allRoomsWithImage=list.stream().map(prod ->
                Product.builder()
                        .id(prod.getId())
                        .name(prod.getName())
                        .price(prod.getPrice())
                        .message(prod.getMessage())
                        .imageBase64(getImageBase64(prod.getImage()))

                        .build()
        );

        list = allRoomsWithImage.toList();
        return list;
    }
    public String getImageBase64(String fileName) {
        if (fileName!=null) {
            String filePath = System.getProperty("user.dir")+"\\images\\";
            File file = new File(filePath + fileName);
            byte[] bytes;
            try {
                bytes = Files.readAllBytes(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return Base64.getEncoder().encodeToString(bytes);
        }
        return null;
    }
}