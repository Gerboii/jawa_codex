package com.example.jawa_codex.controller;

import com.example.jawa_codex.model.Vehicles;
import com.example.jawa_codex.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/vehicles")
public class VehiclesController {
    @Autowired
    private VehiclesService vehiclesService;

    @GetMapping("getById/{id}")
    public void getVehicleById(){}

    @GetMapping("getAll")
    public ResponseEntity<Map<String, Object>> getAllVehicles(){
        Map<String, Object> response = new HashMap<>();
        try {
            List<Vehicles> vehicles = vehiclesService.getAllVehicles();

            response.put("code", 1);
            response.put("message", "Vehículos obtenidos con éxito");
            response.put("data", vehicles);
            response.put("size", vehicles.size());

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.put("code", 3);
            response.put("message", "error en el endpoint");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PostMapping("create")
    public void addVehicle(){}

    @PutMapping("update/{id}")
    public void updateVehicle(){}

    @DeleteMapping("delete/{id}")
    public void deleteVehicle(){}
}
