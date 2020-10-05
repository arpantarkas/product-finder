package com.arpan.productfinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
public class Shop {

    @Id
    private String name;

    @DBRef
    private List<String> productIdList;

}
