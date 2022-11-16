package com.nocountry.ecommerce.controllers;

import com.nocountry.ecommerce.dto.ProductRequest;
import com.nocountry.ecommerce.entities.ProductEntity;
import com.nocountry.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductEntity> save(@RequestBody ProductRequest product){
        ProductEntity prod = new ProductEntity(
                null,
                product.getName(),
                product.getDescription(),
                product.getStock()
        );
        return new ResponseEntity<>(productService.save(prod), HttpStatus.OK);
    }

}
