package com.arpan.productfinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "demodb")
public class Product {

    @Id
    private Long id;
    private String name;
    private Double price;

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
