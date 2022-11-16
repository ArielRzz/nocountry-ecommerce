package com.nocountry.ecommerce.controllers;

import com.nocountry.ecommerce.dto.AuthCredentials;
import com.nocountry.ecommerce.dto.AuthResponse;
import com.nocountry.ecommerce.dto.RegisterDto;
import com.nocountry.ecommerce.entities.AppUser;
import com.nocountry.ecommerce.entities.Role;
import com.nocountry.ecommerce.repository.RoleRepo;
import com.nocountry.ecommerce.repository.UserRepo;
import com.nocountry.ecommerce.security.TokenUtils;
import com.nocountry.ecommerce.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
@AllArgsConstructor
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthCredentials login) throws Exception {
        Authentication authObj;
        try{
            authObj = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authObj);
        } catch (BadCredentialsException e){
            throw new Exception("Credentials invalid");
        }

        UserDetailsImpl userDetails = (UserDetailsImpl) authObj.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getName(), userDetails.getUsername());

        return new ResponseEntity<>(new AuthResponse(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepo.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>("This user already taken", HttpStatus.BAD_REQUEST);
        }
        AppUser user = new AppUser();
        user.setName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(
                passwordEncoder
                        .encode(registerDto.getPassword())
        );

        Role role = roleRepo.findByName("ROLE_USER");
        user.setRoles(Collections.singletonList(role));

        userRepo.save(user);

        String log_message = String.format("User %s registered success", user.getName());
        log.info(log_message);
        return new ResponseEntity<>(log_message, HttpStatus.CREATED);
    }

    @GetMapping("/saludo")
    public ResponseEntity<String> saludo() {
        return new ResponseEntity<>("HOLA", HttpStatus.OK);
    }

}
