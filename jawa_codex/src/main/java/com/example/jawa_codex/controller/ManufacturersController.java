package com.example.jawa_codex.controller;

import com.example.jawa_codex.model.Manufacturers;
import com.example.jawa_codex.service.ManufacturersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/manufacturers")
public class ManufacturersController {
    @Autowired
    private ManufacturersService manufacturersService;

    @GetMapping("getById/{id}")
    public ResponseEntity<Map<String, Object>> getManufacturersById(long id){
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Manufacturers> manufacturersOptional = manufacturersService.getById(id);
            if (manufacturersOptional.isPresent()) {
                response.put("code", 1);
                response.put("message", "Fabricante obtenido con éxito");
                response.put("data", manufacturersOptional.get());
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
    public ResponseEntity<Map<String, Object>> getAllManufacturers(){
        Map<String, Object> response = new HashMap<>();
        try {
            List<Manufacturers> manufacturers = manufacturersService.getAllManufacturers();

            response.put("code", 1);
            response.put("message", "Fabricantes obtenidos con éxito");
            response.put("data", manufacturers);
            response.put("size", manufacturers.size());

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("code", 3);
            response.put("message", "error en el endpoint");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

}
