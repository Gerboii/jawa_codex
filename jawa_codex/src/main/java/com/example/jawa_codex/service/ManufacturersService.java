package com.example.jawa_codex.service;

import com.example.jawa_codex.model.Manufacturers;
import com.example.jawa_codex.model.Starships;
import com.example.jawa_codex.repository.ManufacturersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManufacturersService {
    @Autowired
    private ManufacturersRepository manufacturersRepository;

    //Recibe id -> Devuelve Manufacturer si existe
    public Manufacturers buscarManufacturer(Long id){
        if(manufacturersRepository.findById(id).isPresent()){
            return manufacturersRepository.findById(id).get();
        }else{
            return null;
        }
    }
}
