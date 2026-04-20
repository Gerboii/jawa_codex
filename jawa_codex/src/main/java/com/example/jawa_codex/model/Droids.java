package com.example.jawa_codex.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Droids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String model;
    @Column
    private int height;
    @Column
    private int mass;
    @Column
    private String sensor_color;
    @Column
    private String plating_color;
    @Column
    private String primary_function;
    //TODO Manufacturer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturers manufacturer;
}
