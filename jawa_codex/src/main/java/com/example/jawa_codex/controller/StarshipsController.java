package com.example.jawa_codex.controller;

import com.example.jawa_codex.model.Starships;
import com.example.jawa_codex.service.StarshipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/starships")
public class StarshipsController {
    @Autowired
    private StarshipsService starshipsService;

    @GetMapping("getById/{id}")
    public ResponseEntity<Map<String, Object>> getStarshipById(long id){
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Starships> starshipsOptional = starshipsService.getById(id);
            if (starshipsOptional.isPresent()) {
                response.put("code", 1);
                response.put("message", "Starship obtenido con éxito");
                response.put("data", starshipsOptional.get());
            } else {
                response.put("code", 2);
                response.put("message", "id indicada invalida");
                response.put("data", null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("code", 3);
            response.put("message", "error en el endpoint");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @GetMapping("getAll")
    public ResponseEntity<Map<String, Object>> getAllStarships(){
        Map<String, Object> response = new HashMap<>();
        try {
            List<Starships> starships = starshipsService.getAllStarships();

            response.put("code", 1);
            response.put("message", "Starships obtenidos con éxito");
            response.put("data", starships);
            response.put("size", starships.size());

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("code", 3);
            response.put("message", "error en el endpoint");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> addStarship(@RequestBody Starships starship){
        try {
            Starships starshipNuevo = starshipsService.agregarStarships(starship);
            Map<String, Object> response = new HashMap<>();
            response.put("code", 1);
            response.put("message", "Starship guardada con éxito");
            response.put("data", starshipNuevo);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (DataIntegrityViolationException e) {

            Map<String, Object> response = new HashMap<>();
            response.put("code", 3);
            response.put("message", "Clave duplicada");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PutMapping("update/{id}")
    public void updateStarship(){}

    @DeleteMapping("delete/{id}")
    public void deleteStarship(){}
}
