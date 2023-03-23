package com.example.demo.controllers;

import com.example.demo.models.entity.Auto;
import com.example.demo.models.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auto")
public class AutoController {
    @Autowired
    AutoService autoService;

    @GetMapping("/lista")
    public ResponseEntity<List <Auto>> lista(){
        List<Auto> lista = autoService.lista();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/vermarca/{marca}")
    public ResponseEntity<List<Auto>> verMarca(@PathVariable("marca") String marca){
        List<Auto> autos = autoService.getByMarca(marca);
        return new ResponseEntity(autos, HttpStatus.OK);
    }
}
