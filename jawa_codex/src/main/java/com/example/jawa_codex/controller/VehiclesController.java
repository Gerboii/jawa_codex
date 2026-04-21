package com.example.jawa_codex.controller;

import com.example.jawa_codex.model.Vehicles;
import com.example.jawa_codex.service.VehiclesService;
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
@RequestMapping("api/vehicles")
public class VehiclesController {
    @Autowired
    private VehiclesService vehiclesService;

    @GetMapping("getById/{id}")
    public ResponseEntity<Map<String, Object>> getVehicleById(@PathVariable long id){
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Vehicles> vehicleOptional = vehiclesService.getById(id);
            if (vehicleOptional.isPresent()) {
                response.put("code", 1);
                response.put("message", "Vehículo obtenido con éxito");
                response.put("data", vehicleOptional.get());
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
    public ResponseEntity<Map<String, Object>> addVehicle(@RequestBody Vehicles vehicle){
        try {
            Vehicles vehicleNuevo = vehiclesService.agregarVehicle(vehicle);
            Map<String, Object> response = new HashMap<>();
            response.put("code", 1);
            response.put("message", "Vehículo guardado con éxito");
            response.put("data", vehicleNuevo);
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
    public void updateVehicle(){}

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteVehicle(@PathVariable long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Boolean isDeleted = vehiclesService.eliminarVehicle(id);

            if (isDeleted) {
                response.put("code", 1);
                response.put("message", "Vehículo eliminado con éxito");
                response.put("data", id);
            } else {
                response.put("code", 2);
                response.put("message", "Id indicada inválida o el vehículo no existe");
                response.put("data", null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            response.put("code", 3);
            response.put("message", "Error en el endpoint al intentar eliminar");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
}
