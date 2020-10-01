package com.arpan.productfinder.controller;

import com.arpan.productfinder.model.Product;
import com.arpan.productfinder.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/product")
    public Optional<Product> getProduct(@RequestParam Long id) {
        return productService.getProductById(id);
    }

    @PostMapping(path = "/addProduct", consumes = "application/json")
    public void addProduct(@RequestBody Product product) {
        System.out.println("hello");
        productService.addProduct(product);
    }
}
