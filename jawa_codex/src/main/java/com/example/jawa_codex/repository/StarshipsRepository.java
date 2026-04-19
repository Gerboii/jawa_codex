package com.example.jawa_codex.repository;

import com.example.jawa_codex.model.Starships;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarshipsRepository extends JpaRepository<Starships, Long> {
}
