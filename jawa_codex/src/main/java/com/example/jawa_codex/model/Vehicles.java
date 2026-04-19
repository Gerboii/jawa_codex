package com.example.jawa_codex.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
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
        //TODO Manufacturer
}
