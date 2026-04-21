package com.example.jawa_codex.service;

import com.example.jawa_codex.model.Starships;
import com.example.jawa_codex.repository.StarshipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StarshipsService {
    @Autowired
    private StarshipsRepository starshipsRepository;

    //Devuelve lista con todos los Starships
    public List<Starships> getAllStarships() {
        return starshipsRepository.findAll();
    }

    //Recibe ID -> Devuelve Optional Starships
    public Optional<Starships> getById(Long id){
        return starshipsRepository.findById(id);
    }

    //Recibe Id -> Borra y devuelve True si existe, si no existe devuelve False
    public Boolean eliminarStarships(Long id){
        if (getById(id).isPresent()) {
            starshipsRepository.deleteById(id);
            return true;
        }
        return false;
    }
    //Recibe starship -> Guarda
    public Starships agregarStarships(Starships starship){
        starshipsRepository.save(starship);
        return starship;
    }

    //Recibe ID y nuevos datos -> Actualiza y devuelve Optional Droid
    public Optional<Starships> actualizarStarship(Long id, Starships starshipActualizado){
        if (starshipsRepository.existsById(id)) {
            //Fuerzo que el ID del objeto sea el mismo que el de la URL por seguridad
            starshipActualizado.setId(id);
            //Al tener un Id existente, hace un UPDATE en lugar de un INSERT
            Starships guardado = starshipsRepository.save(starshipActualizado);
            return Optional.of(guardado);
        }
        //Si no existe, devuelve un Optional vacío
        return Optional.empty();
    }
}
