package com.arpan.productfinder.service;

import com.arpan.productfinder.dto.ProductDto;
import com.arpan.productfinder.dto.ResponseDto;
import com.arpan.productfinder.model.Product;
import com.arpan.productfinder.repository.ProductRepository;
import com.arpan.productfinder.util.ProductMapper;
import com.arpan.productfinder.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);

    }

    @Override
    public void addProduct(ProductDto productDto) {
        productRepository.save(ProductMapper.toProduct(productDto));
    }

    @Override
    public ResponseDto<ProductDto> getQuotesFromShops(String productName, Integer pageNo, Integer size) {

        try {
            Pageable sortedBy = PageRequest.of(pageNo, size);
            List<ProductDto> productDtoList = productRepository.findAllByName(productName, sortedBy)
                    .parallelStream()
                    .map(this::toProductDto)
                    .collect(Collectors.toList());

            return ResponseUtil.setSuccessResponse(productDtoList);

        } catch (IllegalArgumentException e) {
            return ResponseUtil.setErrorResponse(e.getMessage());
        }

    }

    @Override
    public ResponseDto<ProductDto> getAllProducts(Integer pageNo, Integer size) {
        try {
            Pageable sortedBy = PageRequest.of(pageNo, size);
            List<ProductDto> productDtoList = productRepository.findAll(sortedBy)
                    .getContent()
                    .parallelStream()
                    .map(this::toProductDto)
                    .collect(Collectors.toList());

            return ResponseUtil.setSuccessResponse(productDtoList);
        } catch (Exception e) {
            return ResponseUtil.setErrorResponse(e.getMessage());
        }
    }

    @Override
    public ResponseDto<ProductDto> getProductsByShop(String shopId, Integer pageNo, Integer size) {

        try {
            Pageable sortedBy = PageRequest.of(pageNo, size);
            List<ProductDto> productDtoList = productRepository.findAllByShopId(shopId, sortedBy)
                    .parallelStream()
                    .map(this::toProductDto)
                    .collect(Collectors.toList());
            return ResponseUtil.setSuccessResponse(productDtoList);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.setErrorResponse(e.getMessage());
        }
    }

    @Override
    public ProductDto toProductDto(Product product) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(product, ProductDto.class);
    }
}
