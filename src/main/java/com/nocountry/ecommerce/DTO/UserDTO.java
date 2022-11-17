package com.nocountry.ecommerce.DTO;

import com.nocountry.ecommerce.entities.CarritoEntity;
import com.nocountry.ecommerce.entities.ProductEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String pass;

    private CarritoEntity carrito;

}
