package com.arpan.productfinder.service;

import com.arpan.productfinder.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProductById(Long id);

    void addProduct(Product product);

    List<Product> getQuotesFromShops(String productName);

    List<Product> getAllProducts();

    List<Product> getProductsByShop(String shopId);

    //    void deleteProductById(String id);
}
