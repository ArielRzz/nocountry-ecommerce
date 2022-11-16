package com.nocountry.ecommerce.mapper;


import com.nocountry.ecommerce.DTO.CarritoDTO;
import com.nocountry.ecommerce.entities.CarritoEntity;
import org.springframework.stereotype.Component;


@Component
public class CarritoMapper{

    public CarritoEntity carritoDTOtoEntity(CarritoDTO dto) {
        CarritoEntity carritoEntity = new CarritoEntity();
        carritoEntity.setUser(dto.getUser());
        carritoEntity.setProductlist(dto.getProductlist());
        return carritoEntity;
    }

    public CarritoDTO carritoEntityToDTO(CarritoEntity entity,boolean loadProducts){
        CarritoDTO dto = new CarritoDTO();
        dto.setId(entity.getId());
        dto.setUser(entity.getUser());
        if (loadProducts){
            List<Product> productRequests = entity.getProductlist();
            dto.setProductlist(productRequests);
        }
        return dto;
    }
}