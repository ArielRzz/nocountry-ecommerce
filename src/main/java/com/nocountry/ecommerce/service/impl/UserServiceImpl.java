package com.nocountry.ecommerce.service.impl;
import com.nocountry.ecommerce.dto.UserDTO;
import com.nocountry.ecommerce.entities.AppUser;
import com.nocountry.ecommerce.entities.Role;
import com.nocountry.ecommerce.entities.UserEntity;
import com.nocountry.ecommerce.mapper.UserMapper;
import com.nocountry.ecommerce.repository.RoleRepository;
import com.nocountry.ecommerce.repository.UserRepository;
import com.nocountry.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserDTO save(UserDTO dto) {
        UserEntity userEntity = userMapper.userDTOtoEntity(dto);
        UserEntity entidadGuardada = userRepository.save(userEntity);
        UserDTO result = userMapper.userEntityToDTO(entidadGuardada);
        System.out.println("Guardar usuario");
        return result;
    }

    public AppUser saveUser(AppUser user){
        log.info("Saving new user into DB");
        return userRepository.save(user);
    }
    public Role saveRole(Role role){
        log.info("Saving new role into DB");
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String rolename){
        log.info("Adding role:{} into user:{}", rolename, username);
        AppUser user = userRepository.findByEmail(username).get();
        Role role = roleRepository.findByName(rolename);
        user.getRoles().add(role); // for @Transactional annotation this save into DB
    }

    public AppUser getUser(String username){
        log.info("Getting user:{}", username);
        return userRepository.findByEmail(username).get();
    }

    public List<AppUser> getUsers(){
        log.info("Getting all users");
        return userRepository.findAll();
    }
}
