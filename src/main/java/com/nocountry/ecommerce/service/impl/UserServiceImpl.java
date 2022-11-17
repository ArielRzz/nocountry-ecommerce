package com.nocountry.ecommerce.service.impl;

import com.nocountry.ecommerce.DTO.UserDTO;
import com.nocountry.ecommerce.entities.UserEntity;
import com.nocountry.ecommerce.mapper.UserMapper;
import com.nocountry.ecommerce.repository.UserRepository;
import com.nocountry.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

     public UserDTO save(UserDTO dto) {
        UserEntity userEntity = userMapper.userDTOtoEntity(dto);
        UserEntity entidadGuardada = userRepository.save(userEntity);
        UserDTO result = userMapper.userEntityToDTO(entidadGuardada);
        System.out.println("Guardar usuario");
        return result;
    }

}
