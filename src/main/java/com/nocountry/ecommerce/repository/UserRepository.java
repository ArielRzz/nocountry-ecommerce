package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.entities.AppUser;
import com.nocountry.ecommerce.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);
    Boolean existsByEmail(String email);

}
