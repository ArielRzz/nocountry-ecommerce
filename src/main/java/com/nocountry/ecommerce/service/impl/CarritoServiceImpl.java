package com.nocountry.ecommerce.service.impl;

import com.nocountry.ecommerce.DTO.CarritoDTO;
import com.nocountry.ecommerce.entities.CarritoEntity;
import com.nocountry.ecommerce.mapper.CarritoMapper;
import com.nocountry.ecommerce.repository.CarritoRepository;
import com.nocountry.ecommerce.service.CarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoMapper carritoMapper;
    @Autowired
    private CarritoRepository carritoRepository;

    public CarritoDTO save(CarritoDTO dto){
        CarritoEntity carritoEntity = carritoMapper.carritoDTOtoEntity(dto);
        //save devuelve la entidad que se guardò.
        //guardamos la entidad
        CarritoEntity entidadGuardada = carritoRepository.save(carritoEntity);
        //pasamos la entidad a dto para mandarlo al controller
        CarritoDTO result = carritoMapper.carritoEntityToDTO(entidadGuardada,false);
        System.out.println("Guardar Carrito");
        return result;
    }

    @Override
    public CarritoDTO getByUser(String idUser) {
        CarritoEntity entidadTraida = carritoRepository.getByUser(idUser);
        CarritoDTO result = carritoMapper.carritoEntityToDTO(entidadTraida,true);
        return null;
    }
}
