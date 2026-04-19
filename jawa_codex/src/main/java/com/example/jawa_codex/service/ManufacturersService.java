package com.example.jawa_codex.service;

import com.example.jawa_codex.model.Droids;
import com.example.jawa_codex.model.Manufacturers;
import com.example.jawa_codex.repository.ManufacturersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ManufacturersService {
    @Autowired
    private ManufacturersRepository manufacturersRepository;

    //Recibe id -> Devuelve Manufacturer si existe
    public Optional<Manufacturers> getById(long id){
        return manufacturersRepository.findById(id);
    }
    //Devuelve lista con todos los Manufacturers
    public List<Manufacturers> getAllManufacturers() {
        return manufacturersRepository.findAll();
    }
}
