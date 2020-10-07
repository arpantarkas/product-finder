package com.arpan.productfinder.service;

import com.arpan.productfinder.dto.ProductDto;
import com.arpan.productfinder.dto.ResponseDto;
import com.arpan.productfinder.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProductById(Long id);

    void addProduct(ProductDto productDto);

    ResponseDto<ProductDto> getQuotesFromShops(String productName, Integer pageNo, Integer size);

    ResponseDto<ProductDto> getAllProducts(Integer pageNo, Integer size);

    ResponseDto<ProductDto> getProductsByShop(String shopId, Integer pageNo, Integer size);

    ProductDto toProductDto(Product product);
    //    void deleteProductById(String id);
}
