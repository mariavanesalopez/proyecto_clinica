package com.proyecto.clinica.controller;


import com.proyecto.clinica.entity.DentistDto;
import com.proyecto.clinica.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dentists")
public class DentistController {
    @Autowired
    IDentistService dentistService;

    @PostMapping
    public ResponseEntity<?> createDentist(@RequestBody DentistDto dentistDto) {
        dentistService.createDentist(dentistDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DentistDto getDentist(@PathVariable Long id){
        return dentistService.readDentist(id);
    }

    @PutMapping
    public ResponseEntity<?> changeDentist(@RequestBody DentistDto dentistDto){
        dentistService.changeDentist(dentistDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable Long id){
        dentistService.removeDentist(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping
    public Collection<DentistDto> getAllDentist(){
        return dentistService.getAll();
    }




}
