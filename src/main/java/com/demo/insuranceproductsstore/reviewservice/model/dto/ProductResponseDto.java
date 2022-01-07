package com.demo.insuranceproductsstore.reviewservice.model.dto;

import com.demo.insuranceproductsstore.reviewservice.configuration.Config;
import com.demo.insuranceproductsstore.reviewservice.model.entity.Product;

public class ProductResponseDto {

    private Long id;
    private String productCode;
    private String productName;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ProductResponseDto convertToDto(Product product) {
        return Config.modelMapper().map(product, ProductResponseDto.class);
    }
}
