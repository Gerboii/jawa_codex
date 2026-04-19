package com.example.jawa_codex.controller;

import com.example.jawa_codex.model.Droids;
import com.example.jawa_codex.service.DroidsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/droids")
public class DroidsController {
    @Autowired
    private DroidsService droidsService;

    @GetMapping("getById/{id}")
    public void getDroidById(){}

    @GetMapping("getAll")
    public ResponseEntity<Map<String, Object>> getAllDroids(){
        Map<String, Object> response = new HashMap<>();
        try {
            List<Droids> droids = droidsService.getAllDroids();

            response.put("code", 1);
            response.put("message", "Droides obtenidos con éxito");
            response.put("data", droids);
            response.put("size", droids.size());

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("code", 3);
            response.put("message", "error en el endpoint");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PostMapping("create")
    public void addDroid(){}

    @PutMapping("update/{id}")
    public void updateDroid(){}

    @DeleteMapping("delete/{id}")
    public void deleteDroid(){}

}
