package com.nocountry.ecommerce.controllers;

import com.nocountry.ecommerce.DTO.ProductDTO;
import com.nocountry.ecommerce.DTO.UserDTO;
import com.nocountry.ecommerce.service.ProductService;
import com.nocountry.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/guardar")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO){
        UserDTO userGuardado = userService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userGuardado) ;
    }

}
