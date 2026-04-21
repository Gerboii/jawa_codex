package com.example.jawa_codex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String model;
    @Column
    private int cost_in_credits;
    @Column
    private int lenght;
    @Column
    private int max_atmosphering_speed;
    @Column
    private int crew;
    @Column
    private int passengers;
    @Column
    private int cargo_capacity;
    @Column
    private String consumables;
    @Column
    private String vehicle_class;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    //Añadido para evitar recursividad en JSON
    @JsonIgnoreProperties({"droids", "vehicles", "starships"})
    private Manufacturers manufacturer;
}
