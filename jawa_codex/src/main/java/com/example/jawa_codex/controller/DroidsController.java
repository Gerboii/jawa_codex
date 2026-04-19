package com.example.jawa_codex.controller;

import com.example.jawa_codex.service.DroidsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/droids")
public class DroidsController {
    @Autowired
    private DroidsService droidsService;

    @GetMapping("getById/{id}")
    public void getDroidById(){}

    @GetMapping("getAll")
    public void getAllDroids(){}

    @PostMapping("create")
    public void addDroid(){}

    @PutMapping("update/{id}")
    public void updateDroid(){}

    @DeleteMapping("delete/{id}")
    public void deleteDroid(){}

}
