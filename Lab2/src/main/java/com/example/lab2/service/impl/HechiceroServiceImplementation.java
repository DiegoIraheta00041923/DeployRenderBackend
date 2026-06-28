package com.example.lab2.service.impl;

import com.example.lab2.domain.entity.Hechicero;
import com.example.lab2.repository.HechiceroRepository;
import com.example.lab2.service.HechiceroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HechiceroServiceImplementation implements HechiceroService {
    private final HechiceroRepository hechiceroRepository;

    @Override
    public void createHechicero(Hechicero hechicero){
        hechiceroRepository.save(hechicero);
    }

    @Override
    public List<Hechicero> getHechiceros(){
        return hechiceroRepository.findAll();
    }
    @Override
    public Hechicero getHechiceroByID(UUID id){
        Optional<Hechicero> hechicero = hechiceroRepository.findById(id);
        return hechicero.isPresent() ? hechicero.get() : null;
    }

    @Override
    public void updateHechiero(UUID id,Hechicero hechicero){
        Optional<Hechicero> existHechicero = hechiceroRepository.findById(id);
        existHechicero.get().setName(hechicero.getName());
        existHechicero.get().setGrade(hechicero.getGrade());
        existHechicero.get().setCursedTechnique(hechicero.getCursedTechnique());
        existHechicero.get().setSchool(hechicero.getSchool());
        existHechicero.get().setCursedEnergy(hechicero.getCursedEnergy());
        existHechicero.get().setIsActive(hechicero.getIsActive());
        hechiceroRepository.save(existHechicero.get());

    }
    @Override
    public Hechicero deleteHechicero(UUID id){
        Optional<Hechicero> existHechicero = hechiceroRepository.findById(id);
        hechiceroRepository.deleteById(id);
        return existHechicero.get();
    }

    @Override
    public List<Hechicero> getHechicerosBySchool(String school){
        return hechiceroRepository.findBySchool(school);
    }
    @Override
    public List<Hechicero> getHechicerosByGrade(String grade){
        return hechiceroRepository.findByGrade(grade);
    }
    @Override
    public List<Hechicero> getActiveHechiceros(Boolean isActive){
        return hechiceroRepository.findByisActive(isActive);
    }
}
