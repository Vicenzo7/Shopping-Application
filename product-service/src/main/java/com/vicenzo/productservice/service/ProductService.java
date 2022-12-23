package com.vicenzo.productservice.service;

import com.vicenzo.productservice.dto.ProductRequest;
import com.vicenzo.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
