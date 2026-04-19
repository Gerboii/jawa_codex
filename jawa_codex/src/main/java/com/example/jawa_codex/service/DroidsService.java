package com.example.jawa_codex.service;

import com.example.jawa_codex.model.Droids;
import com.example.jawa_codex.repository.DroidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DroidsService {
    @Autowired
    private DroidsRepository droidsRepository;

    //Recibe id -> Devuelve Droid si existe
    public Droids buscarDroid(Long id){
        if(droidsRepository.findById(id).isPresent()){
            return droidsRepository.findById(id).get();
        }else{
            return null;
        }
    }
    public void eliminarDroid(Droids droid){
        droidsRepository.delete(droid);
    }
    public void agregarDroid(Droids droid){
        droidsRepository.save(droid);
    }
}
