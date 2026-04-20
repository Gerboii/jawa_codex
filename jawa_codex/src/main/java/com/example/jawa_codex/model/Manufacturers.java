package com.example.jawa_codex.model;

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

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private List<Droids> droids;
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private List<Vehicles> vehicles;
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private List<Starships> starships;
}