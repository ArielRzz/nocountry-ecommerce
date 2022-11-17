package com.nocountry.ecommerce.service.impl;

import com.nocountry.ecommerce.DTO.ProductDTO;
import com.nocountry.ecommerce.entities.ProductEntity;
import com.nocountry.ecommerce.mapper.ProductMapper;
import com.nocountry.ecommerce.repository.ProductRepository;
import com.nocountry.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;
    @Override
     public ProductDTO save(ProductDTO dto) {
        ProductEntity productEntity = productMapper.productDTOtoEntity(dto);
        ProductEntity entidadGuardada = productRepository.save(productEntity);
        ProductDTO result = productMapper.productEntityToDTO(entidadGuardada);
        System.out.println("Guardar producto");
        return result;
    }
}
