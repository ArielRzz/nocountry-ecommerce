package com.nocountry.ecommerce.entities;

import com.nocontry.models.Product;
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
    private List<Product> productlist;

    public void addProduct(Product product){
        productlist.add(product);
    }

    public void removeProduct(Product product){
        productlist.remove(product);
    }


}
