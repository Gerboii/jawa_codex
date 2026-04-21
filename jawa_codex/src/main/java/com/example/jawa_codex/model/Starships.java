package com.example.jawa_codex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Starships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String model;
    @Column
    private Integer cost_in_credits;
    @Column
    private Integer lenght;
    @Column
    private Integer max_atmosphering_speed;
    @Column
    private Integer crew;
    @Column
    private Integer passengers;
    @Column
    private Integer cargo_capacity;
    @Column
    private String consumables;
    @Column
    private Integer hyperdrive_rating;
    @Column
    private Integer MGLT;
    @Column
    private String starship_class;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    //Añadido para evitar recursividad en JSON
    @JsonIgnoreProperties({"droids", "vehicles", "starships"})
    private Manufacturers manufacturer;
}
