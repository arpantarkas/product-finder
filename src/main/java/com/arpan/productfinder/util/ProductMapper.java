package com.arpan.productfinder.util;

import com.arpan.productfinder.dto.ProductDto;
import com.arpan.productfinder.model.Product;

public class ProductMapper {

    public static Product toProduct (ProductDto productDto) {
        return new Product( productDto.getId(),
                            productDto.getName(),
                            productDto.getPrice(),
                            productDto.getShopId()
                        );
    }

}
