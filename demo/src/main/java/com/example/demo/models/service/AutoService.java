package com.example.demo.models.service;

import com.example.demo.models.entity.Auto;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoService {
    @Autowired
    AutoRepository autoRepository;
    public List<Auto> lista(){
        return autoRepository.listaProcedure();
    }

    public Optional<Auto> getById(int id){
        return autoRepository.idProcedure(id);
    }

    public List<Auto> getByMarca(String marca){
        return autoRepository.marcaProcedure(marca);
    }
}
