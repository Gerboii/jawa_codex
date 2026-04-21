package com.example.jawa_codex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Manufacturers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;

    //Evito el bucle infinito de JSON en ambos sentidos
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("manufacturer")
    private List<Droids> droids;
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("manufacturer")
    private List<Vehicles> vehicles;
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("manufacturer")
    private List<Starships> starships;
}