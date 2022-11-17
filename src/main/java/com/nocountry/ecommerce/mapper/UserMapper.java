package com.nocountry.ecommerce.mapper;

import com.nocountry.ecommerce.dto.CarritoDTO;
import com.nocountry.ecommerce.dto.UserDTO;
import com.nocountry.ecommerce.entities.CarritoEntity;
import com.nocountry.ecommerce.entities.ProductEntity;
import com.nocountry.ecommerce.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserMapper {

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

    public UserEntity userDTOtoEntity(UserDTO user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());

        return userEntity;
    }

    public UserDTO userEntityToDTO(UserEntity user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}