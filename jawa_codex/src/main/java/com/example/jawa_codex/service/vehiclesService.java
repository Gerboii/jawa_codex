package com.example.jawa_codex.service;

import com.example.jawa_codex.repository.vehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class vehiclesService {
    @Autowired
    private vehiclesRepository vehiclesRepository;
}
