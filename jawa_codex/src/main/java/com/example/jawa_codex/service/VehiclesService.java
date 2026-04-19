package com.example.jawa_codex.service;

import com.example.jawa_codex.model.Vehicles;
import com.example.jawa_codex.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehiclesService {
    @Autowired
    private VehiclesRepository vehiclesRepository;

    //Recibe id -> Devuelve vehiculo si existe
    public Vehicles buscarVehiculo(Long id){
        if(vehiclesRepository.findById(id).isPresent()){
            return vehiclesRepository.findById(id).get();
        }else{
            return null;
        }
    }
    public void agregarVehiculo(Vehicles vehiculo){
        vehiclesRepository.save(vehiculo);
    }
    public void eliminarVehiculo(Vehicles vehiculo){
        vehiclesRepository.delete(vehiculo);
    }
}
