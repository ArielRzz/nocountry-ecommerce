package com.nocountry.ecommerce.mapper;


import com.nocountry.ecommerce.dto.CarritoDTO;
import com.nocountry.ecommerce.entities.CarritoEntity;
import com.nocountry.ecommerce.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CarritoMapper{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    public CarritoEntity carritoDTOtoEntity(CarritoDTO dto) {
        CarritoEntity carritoEntity = new CarritoEntity();
        carritoEntity.setUser(userMapper.userDTOtoEntity(dto.getUser()));
        carritoEntity.setProductlist(productMapper.productListDTOtoEntityList(dto.getProductlist()));
        return carritoEntity;
    }

    public CarritoDTO carritoEntityToDTO(CarritoEntity entity,boolean loadProducts){
        CarritoDTO dto = new CarritoDTO();
        dto.setId(entity.getId());
        dto.setUser(userMapper.userEntityToDTO(entity.getUser()));
        if (loadProducts){
            List<ProductEntity> productlist = entity.getProductlist();
            dto.setProductlist(productMapper.productEntityListToDTOList(productlist));
        }
        return dto;
    }
}