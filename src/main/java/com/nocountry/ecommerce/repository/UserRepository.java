package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.entities.CarritoEntity;
import com.nocountry.ecommerce.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
