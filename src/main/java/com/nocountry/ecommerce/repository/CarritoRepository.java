package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.entities.CarritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<CarritoEntity, Long> {

    CarritoEntity getByUser(String user);
}
