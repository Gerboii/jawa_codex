package com.example.jawa_codex.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Starships {
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
    private int hyperdrive_rating;
    @Column
    private int MGLT;
    @Column
    private String starship_class;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturers manufacturer;
}
