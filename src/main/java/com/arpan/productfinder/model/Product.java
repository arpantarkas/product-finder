package com.arpan.productfinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private Double price;
    private String shopId;


    public Product(String name, Double price, String shopId) {
        this.name = name;
        this.price = price;
        this.shopId = shopId;
    }
}
