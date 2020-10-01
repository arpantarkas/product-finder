package com.arpan.productfinder.service;

import com.arpan.productfinder.model.Product;
import com.arpan.productfinder.model.ProductDTO;

import java.util.Optional;

public interface ProductService {

    Optional<Product> getProductById(Long id);
    void addProduct(Product product);
}
