package com.example.jawa_codex.service;

import com.example.jawa_codex.repository.starshipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class starshipsService {
    @Autowired
    private starshipsRepository starshipsRepository;
}
