package com.arpan.productfinder.model;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;

    public ProductDTO(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
