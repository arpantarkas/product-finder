package com.arpan.productfinder.repository;

import com.arpan.productfinder.model.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

    List<Product> findAllByName(String productName, Pageable pageable);

    List<Product> findAllByShopId(String shopId, Pageable pageable);

}
