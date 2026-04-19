package com.example.jawa_codex.controller;

import com.example.jawa_codex.service.DroidsService;
import com.example.jawa_codex.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vehicles")
public class VehiclesController {
    @Autowired
    private VehiclesService vehiclesService;

    @GetMapping("getById/{id}")
    public void getVehicleById(){}

    @GetMapping("getAll")
    public void getAllVehicles(){}

    @PostMapping("create")
    public void addVehicle(){}

    @PutMapping("update/{id}")
    public void updateVehicle(){}

    @DeleteMapping("delete/{id}")
    public void deleteVehicle(){}
}
