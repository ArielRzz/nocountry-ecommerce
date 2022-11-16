package com.nocountry.ecommerce.DTO;

import com.nocontry.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="carrito")
public class CarritoDTO {

    private Long id;
    private String user;
    @OneToMany
    private List<Product> productlist;


}
