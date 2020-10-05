package com.arpan.productfinder.repository;

import com.arpan.productfinder.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

    List<Product> findAllByNameOrderByPriceAsc(String productName);

    List<Product> findAllByShopIdOrderByNameAsc(String shopId);

}
