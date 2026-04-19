package com.example.jawa_codex.service;

import com.example.jawa_codex.model.Starships;
import com.example.jawa_codex.repository.StarshipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StarshipsService {
    @Autowired
    private StarshipsRepository starshipsRepository;

    //Recibe id -> Devuelve Starship si existe
    public Starships buscarStarship(Long id){
        if(starshipsRepository.findById(id).isPresent()){
            return starshipsRepository.findById(id).get();
        }else{
            return null;
        }
    }
    
    public void agregarStarship(Starships starship){
        starshipsRepository.save(starship);
    }
    public void eliminarStarship(Starships starship){
        starshipsRepository.delete(starship);
    }
}
