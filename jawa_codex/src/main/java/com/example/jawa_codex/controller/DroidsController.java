package com.example.jawa_codex.controller;

import com.example.jawa_codex.model.Droids;
import com.example.jawa_codex.service.DroidsService;
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
@RequestMapping("api/droids")
public class DroidsController {
    @Autowired
    private DroidsService droidsService;

    @GetMapping("getById/{id}")
    public ResponseEntity<Map<String, Object>> getDroidById(@PathVariable long id){
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Droids> droideOptional = droidsService.getById(id);
            if (droideOptional.isPresent()) {
                response.put("code", 1);
                response.put("message", "Droide obtenido con éxito");
                response.put("data", droideOptional.get());
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
    public ResponseEntity<Map<String, Object>> addDroid(@RequestBody Droids droid){
        try {
            Droids droideNuevo = droidsService.agregarDroid(droid);
            Map<String, Object> response = new HashMap<>();
            response.put("code", 1);
            response.put("message", "Droide guardado con éxito");
            response.put("data", droideNuevo);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (DataIntegrityViolationException e) {

            Map<String, Object> response = new HashMap<>();
            response.put("code", 3);
            response.put("message", "Clave duplicada");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
    //Pasar en el body el obj completo o sobrescribira los campos vacios como null
    @PutMapping("update/{id}")
    public ResponseEntity<Map<String, Object>> updateDroid(@PathVariable long id, @RequestBody Droids droid) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Droids> droideActualizado = droidsService.actualizarDroid(id, droid);

            if (droideActualizado.isPresent()) {
                response.put("code", 1);
                response.put("message", "Droide actualizado con éxito");
                response.put("data", droideActualizado.get());
            } else {
                response.put("code", 2);
                response.put("message", "Id indicada inválida o el droide no existe");
                response.put("data", null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            response.put("code", 3);
            response.put("message", "Error en el endpoint al intentar actualizar");
            response.put("data", e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteDroid(@PathVariable long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            // El service nos devuelve true si se eliminó y false si no existía
            Boolean isDeleted = droidsService.eliminarDroid(id);

            if (isDeleted) {
                response.put("code", 1);
                response.put("message", "Droide eliminado con éxito");
                response.put("data", id);
            } else {
                response.put("code", 2);
                response.put("message", "Id indicada inválida o el droide no existe");
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
