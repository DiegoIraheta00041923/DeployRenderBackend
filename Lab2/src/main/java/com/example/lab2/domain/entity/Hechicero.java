package com.example.lab2.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@jakarta.persistence.Entity
@Table(name = "Hechicero")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hechicero {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "grade")
    private String grade;

    @Column(name = "cursedTechnique")
    private String cursedTechnique;

    @Column(name = "school")
    private String school;

    @Column(name = "cursedEnergy")
    private Double cursedEnergy;

    @Column(name = "Active")
    private Boolean isActive;


}
