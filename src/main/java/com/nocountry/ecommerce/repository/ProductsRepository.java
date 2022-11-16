package com.nocountry.ecommerce.repository;

import com.nocountry.ecommerce.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductEntity, String> {

}
