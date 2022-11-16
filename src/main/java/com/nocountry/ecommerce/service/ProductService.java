package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.entities.ProductEntity;
import com.nocountry.ecommerce.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductsRepository productsRepository;

    public ProductEntity save(ProductEntity product){
        return productsRepository.save(product);
    }

}
