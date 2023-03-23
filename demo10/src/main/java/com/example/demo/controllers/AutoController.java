package com.example.demo.controllers;

import com.example.demo.models.entity.Auto;
import com.example.demo.models.repository.AutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AutoController {

    @Autowired
    private AutoDAO autoDAO;

    @GetMapping("/autos")
    public ResponseEntity<List<Auto>> getAll() {
        List<Auto> autos = autoDAO.getAll();
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }

    @GetMapping("/autos/marca/{marca}")
    public ResponseEntity<List<Auto>> getByMarca(@PathVariable("marca") String marca) {
        List<Auto> autos = autoDAO.getByMarca(marca);
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }
}