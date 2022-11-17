package com.nocountry.ecommerce.service;

import com.nocountry.ecommerce.dto.UserDTO;
import com.nocountry.ecommerce.entities.AppUser;
import com.nocountry.ecommerce.entities.Role;
import com.nocountry.ecommerce.entities.UserEntity;

import java.util.List;

public interface UserService{

    public UserDTO save(UserDTO userDTO);

    public AppUser saveUser(AppUser user);

    public Role saveRole(Role role);

    public void addRoleToUser(String username, String rolename);

    public AppUser getUser(String username);

    public List<AppUser> getUsers();

}
