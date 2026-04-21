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
public class Droids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String model;
    @Column
    private Integer height;
    @Column
    private Integer mass;
    @Column
    private String sensor_color;
    @Column
    private String plating_color;
    @Column
    private String primary_function;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    //Añadido para evitar recursividad en JSON
    @JsonIgnoreProperties({"droids", "vehicles", "starships"})
    private Manufacturers manufacturer;
}
