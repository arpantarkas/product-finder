package com.arpan.productfinder.controller;

import com.arpan.productfinder.model.Product;
import com.arpan.productfinder.service.ProductService;
import com.arpan.productfinder.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    private ProductService productService;


    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(path = "/addProduct", consumes = "application/json")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }


    @GetMapping("/search/product")
    public List<Product> getQuotesFromShops(@RequestParam String name) {
        return productService.getQuotesFromShops(name);
    }

    @GetMapping("/search/shop")
    public  List<Product> getAllProductsOfShop(@RequestParam String name) {
        return  productService.getProductsByShop(name);
    }

    // Product Update
    // Product Delete

}
