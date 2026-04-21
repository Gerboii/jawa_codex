package com.example.jawa_codex.service;

import com.example.jawa_codex.model.Vehicles;
import com.example.jawa_codex.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehiclesService {
    @Autowired
    private VehiclesRepository vehiclesRepository;

    //Devuelve lista con todos los vehicle
    public List<Vehicles> getAllVehicles() {
        return vehiclesRepository.findAll();
    }

    //Recibe ID -> Devuelve Optional Vehicle
    public Optional<Vehicles> getById(Long id){
        return vehiclesRepository.findById(id);
    }

    //Recibe Id -> Borra y devuelve True si existe, si no existe devuelve False
    public Boolean eliminarVehicle(Long id){
        if (getById(id).isPresent()) {
            vehiclesRepository.deleteById(id);
            return true;
        }
        return false;
    }
    //Recibe vehicle -> Guarda
    public Vehicles agregarVehicle(Vehicles vehicle){
        vehiclesRepository.save(vehicle);
        return vehicle;
    }
    //Recibe ID y nuevos datos -> Actualiza y devuelve Optional Droid
    public Optional<Vehicles> actualizarVehicle(Long id, Vehicles vehicleActualizado){
        if (vehiclesRepository.existsById(id)) {
            //Fuerzo que el ID del objeto sea el mismo que el de la URL por seguridad
            vehicleActualizado.setId(id);
            //Al tener un Id existente, hace un UPDATE en lugar de un INSERT
            Vehicles guardado = vehiclesRepository.save(vehicleActualizado);
            return Optional.of(guardado);
        }
        //Si no existe, devuelve un Optional vacío
        return Optional.empty();
    }
}
