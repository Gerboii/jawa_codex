package com.example.jawa_codex.controller;

import com.example.jawa_codex.service.ManufacturersService;
import com.example.jawa_codex.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/manufacturers")
public class ManufacturersController {
    @Autowired
    private ManufacturersService manufacturersService;

    @GetMapping("getById/{id}")
    public void getManufacturersById(){}

    @GetMapping("getAll")
    public void getAllManufacturers(){}

}
