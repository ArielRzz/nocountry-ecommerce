package com.nocountry.ecommerce.mapper;


import com.nocountry.ecommerce.DTO.ProductDTO;
import com.nocountry.ecommerce.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductMapper {

    public ProductEntity productDTOtoEntity(ProductDTO dto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(dto.getName());
        productEntity.setDescription(dto.getDescription());
        productEntity.setStock(dto.getStock());
        return productEntity;
    }

    public ProductDTO productEntityToDTO(ProductEntity entity){
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
       dto.setDescription(entity.getDescription());
       dto.setStock(entity.getStock());
        return dto;
    }

    public List<ProductEntity> productListDTOtoEntityList(List<ProductDTO> productlist) {
        List<ProductEntity> productEntityList = new ArrayList<>();
        for(ProductDTO prod:productlist){
            productEntityList.add(productDTOtoEntity(prod));
        }
        return productEntityList;
    }

    public List<ProductDTO> productEntityListToDTOList(List<ProductEntity> productlist) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (ProductEntity prod:productlist){
            productDTOList.add(productEntityToDTO(prod));
        }
        return productDTOList;

    }
}