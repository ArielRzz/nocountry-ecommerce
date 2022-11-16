package com.nocountry.ecommerce.service;
import com.nocountry.ecommerce.dto.CarritoDTO;


public interface CarritoService {

    CarritoDTO save(CarritoDTO dto);

    CarritoDTO getByUser(String idUser);
}
