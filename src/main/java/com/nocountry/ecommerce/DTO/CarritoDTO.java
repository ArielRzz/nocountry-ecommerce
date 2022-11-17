package com.nocountry.ecommerce.DTO;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO {

    private Long id;
    private UserDTO user;
    private List<ProductDTO> productlist;


}
