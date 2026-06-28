package com.example.lab2.controller;


import com.example.lab2.domain.entity.Hechicero;
import com.example.lab2.service.impl.HechiceroServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/hechicero")
@AllArgsConstructor
public class HechiceroController {
    private final HechiceroServiceImplementation hechiceroServiceImp;

    @PostMapping("/create")
    public ResponseEntity<Hechicero> createHechicero(@RequestBody Hechicero hechicero){
        hechiceroServiceImp.createHechicero(hechicero);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hechicero);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Hechicero>> getHechiceros(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hechiceroServiceImp.getHechiceros());
    }

    @GetMapping("/getHechicero/{id}")
    public ResponseEntity <Hechicero> getHechicero(@PathVariable UUID id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hechiceroServiceImp.getHechiceroByID(id));
    }

    @GetMapping("/getHechiceros/school/{school}")
    public ResponseEntity <List<Hechicero>> getHechicerosBySchool(@PathVariable String school){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hechiceroServiceImp.getHechicerosBySchool(school));

    }

    @GetMapping("/getHechiceros/grade/{grade}")
    public ResponseEntity <List<Hechicero>> getHechicerosByGrade(@PathVariable String grade){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hechiceroServiceImp.getHechicerosByGrade(grade));

    }

    @GetMapping("/getHechiceros/active/{isActive}")
    public ResponseEntity <List<Hechicero>> getActiveHechiceros(@PathVariable Boolean isActive){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hechiceroServiceImp.getActiveHechiceros(isActive));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hechicero> updateProduct(
            @PathVariable UUID id,
            @RequestBody Hechicero hechicero
    ) {
        hechiceroServiceImp.updateHechiero(id,hechicero);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hechicero);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Hechicero> deleteProduct(
            @PathVariable UUID id
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hechiceroServiceImp.deleteHechicero(id));
    }

}
