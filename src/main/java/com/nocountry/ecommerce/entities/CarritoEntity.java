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
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    /*@OneToOne*/
    private String user;
    @OneToMany
    private List<ProductEntity> productlist;

    public void addProduct(ProductEntity product){
        productlist.add(product);
    }

    public void removeProduct(ProductEntity product){
        productlist.remove(product);
    }


}
