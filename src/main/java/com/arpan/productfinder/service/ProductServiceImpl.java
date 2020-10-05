package com.arpan.productfinder.service;

import com.arpan.productfinder.model.Product;
import com.arpan.productfinder.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);

    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getQuotesFromShops(String productName) {
        return productRepository.findAllByNameOrderByPriceAsc(productName);
    }

    @Override
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByShop(String shopId) {
        return productRepository.findAllByShopIdOrderByNameAsc(shopId);
    }

}
