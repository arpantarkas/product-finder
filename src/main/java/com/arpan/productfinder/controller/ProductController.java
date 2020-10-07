package com.arpan.productfinder.controller;

import com.arpan.productfinder.dto.ProductDto;
import com.arpan.productfinder.dto.ResponseDto;
import com.arpan.productfinder.model.Product;
import com.arpan.productfinder.service.ProductService;
import com.arpan.productfinder.service.ProductServiceImpl;
import com.arpan.productfinder.util.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("productServiceImpl") ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products/all")
    public ResponseDto<ProductDto> getAllProducts(@RequestParam Integer pageNo,
                                                  @RequestParam Integer size) {
        return productService.getAllProducts(pageNo, size);
    }

    @PostMapping(path = "/products", consumes = "application/json")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }


    @GetMapping("/products")
    public ResponseDto<ProductDto> getQuotesFromShops(@RequestParam String name,
                                                      @RequestParam Integer pageNo,
                                                      @RequestParam Integer size
                                            ) {
        return productService.getQuotesFromShops(name, pageNo, size);
    }

    @GetMapping("/shop/{shopId}/products")
    public  ResponseDto<ProductDto> getAllProductsOfShop(@PathVariable String shopId,
                                                         @RequestParam Integer pageNo,
                                                         @RequestParam Integer size) {

        return productService.getProductsByShop(shopId, pageNo, size);
    }

    // Product Update
    // Product Delete

}
