package com.arpan.productfinder.repository;

import com.arpan.productfinder.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

}
