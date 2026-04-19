package com.example.jawa_codex.controller;

import com.example.jawa_codex.service.DroidsService;
import com.example.jawa_codex.service.StarshipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/starships")
public class StarshipsController {
    @Autowired
    private StarshipsService starshipsService;

    @GetMapping("getById/{id}")
    public void getStarshipById(){}

    @GetMapping("getAll")
    public void getAllStarships(){}

    @PostMapping("create")
    public void addStarship(){}

    @PutMapping("update/{id}")
    public void updateStarship(){}

    @DeleteMapping("delete/{id}")
    public void deleteStarship(){}
}
