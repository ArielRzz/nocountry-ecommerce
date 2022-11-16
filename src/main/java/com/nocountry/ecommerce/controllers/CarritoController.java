package com.nocountry.ecommerce.controllers;
import com.nocountry.ecommerce.DTO.CarritoDTO;
import com.nocountry.ecommerce.service.CarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carrito")
@RequiredArgsConstructor
public class CarritoController {

    @Autowired
    private CarritoService carritoService;



    @PostMapping("/guardar")
    public ResponseEntity<CarritoDTO> save(/*@Valid*/ @RequestBody CarritoDTO carritoDTO){
        CarritoDTO carritoGuardado = carritoService.save(carritoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(carritoGuardado) ;
    }


    @GetMapping("/{idUser}")
    public CarritoDTO getCarrito(@PathVariable String idUser){
        CarritoDTO CarritoTraido = carritoService.getByUser(idUser);
        return CarritoTraido;
    }
}
