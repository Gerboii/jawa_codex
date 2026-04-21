package com.example.jawa_codex.service;

import com.example.jawa_codex.model.Droids;
import com.example.jawa_codex.repository.DroidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DroidsService {
    @Autowired
    private DroidsRepository droidsRepository;

    //Devuelve lista con todos los Droids
    public List<Droids> getAllDroids() {
        return droidsRepository.findAll();
    }

    //Recibe ID -> Devuelve Optional Droid
    public Optional<Droids> getById(Long id){
        return droidsRepository.findById(id);
    }

    //Recibe Id -> Borra y devuelve True si existe, si no existe devuelve False
    public Boolean eliminarDroid(Long id){
       if (getById(id).isPresent()) {
           droidsRepository.deleteById(id);
           return true;
       }
       return false;
    }

    //Recibe droid -> Guarda
    public Droids agregarDroid(Droids droid){
        droidsRepository.save(droid);
        return droid;
    }

    //Recibe ID y nuevos datos -> Actualiza y devuelve Optional Droid
    public Optional<Droids> actualizarDroid(Long id, Droids droidActualizado){
        if (droidsRepository.existsById(id)) {
            //Fuerzo que el ID del objeto sea el mismo que el de la URL por seguridad
            droidActualizado.setId(id);
            //Al tener un Id existente, hace un UPDATE en lugar de un INSERT
            Droids guardado = droidsRepository.save(droidActualizado);
            return Optional.of(guardado);
        }
        //Si no existe, devuelve un Optional vacío
        return Optional.empty();
    }
}
