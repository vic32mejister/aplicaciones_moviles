package com.univer.inventory.controller;

import com.univer.inventory.Repository.ProductoRepository;
import com.univer.inventory.entity.ProductoEntity;
import com.univer.inventory.model.request.ProductoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductosController {

    @Autowired
    private ProductoRepository repository;

    @GetMapping("all")
    public List<String> productos(){
        return Arrays.asList("tornillos, tuercas, clavos");
    }

    @PostMapping("/save/product")
    public ResponseEntity<String> save(@RequestBody ProductoRequest request){
        ProductoEntity entity = new ProductoEntity();
        entity.setNombre(request.getName());
        entity.setSku(request.getSku());
        entity.setCantidad(request.getCantidad());

        repository.save(entity);

        return ResponseEntity.ok("todo bien");
    }
}

