package com.arpan.productfinder.service;

import com.arpan.productfinder.model.Product;
import com.arpan.productfinder.model.ProductDTO;
import com.arpan.productfinder.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
        Product product1 = new Product(product.getId(), product.getName(), product.getPrice());
        productRepository.save(product1);
//        productRepository.insert(product1);
    }
}
