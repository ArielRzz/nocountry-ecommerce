package com.nocountry.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carrito")
public class CarritoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_ID")
    private UserEntity user;
    @OneToMany
    private List<ProductEntity> productlist;

    public void addProduct(ProductEntity product){
        productlist.add(product);
    }

    public void removeProduct(ProductEntity product){
        productlist.remove(product);
    }


}
