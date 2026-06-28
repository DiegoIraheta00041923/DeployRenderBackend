package com.example.lab2.service;

import com.example.lab2.domain.entity.Hechicero;

import java.util.List;
import java.util.UUID;

public interface HechiceroService {
    void createHechicero(Hechicero hechicero);
    List<Hechicero> getHechiceros();
    Hechicero getHechiceroByID(UUID id);
    void updateHechiero(UUID id,Hechicero hechicero);
    Hechicero deleteHechicero(UUID id);
    List<Hechicero> getHechicerosBySchool(String school);
    List<Hechicero> getHechicerosByGrade(String grade);
    List<Hechicero> getActiveHechiceros(Boolean active);
}
