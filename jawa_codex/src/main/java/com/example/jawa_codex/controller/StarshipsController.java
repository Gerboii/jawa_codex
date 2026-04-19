package com.example.jawa_codex.controller;

import com.example.jawa_codex.model.Starships;
import com.example.jawa_codex.service.StarshipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/starships")
public class StarshipsController {
    @Autowired
    private StarshipsService starshipsService;

    @GetMapping("getById/{id}")
    public void getStarshipById(){}

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
    public void addStarship(){}

    @PutMapping("update/{id}")
    public void updateStarship(){}

    @DeleteMapping("delete/{id}")
    public void deleteStarship(){}
}
