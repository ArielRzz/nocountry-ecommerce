package com.nocountry.ecommerce.dto;

import com.nocountry.ecommerce.entities.CarritoEntity;
import lombok.*;


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
