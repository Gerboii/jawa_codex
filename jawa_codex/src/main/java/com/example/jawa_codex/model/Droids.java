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
}
