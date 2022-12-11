package com.proyecto.clinica.controller;


import com.proyecto.clinica.entity.PatientDto;
import com.proyecto.clinica.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    IPatientService patientService;

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody PatientDto patientDto) {
        patientService.createPatient(patientDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PatientDto getPatient(@PathVariable Long id){
        return patientService.readPatient(id);
        }

     @PutMapping
     public ResponseEntity<?> changePatient(@RequestBody PatientDto patientDto){
        patientService.changePatient(patientDto);
        return ResponseEntity.ok(HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<?> deletePatient(@PathVariable Long id){
         patientService.removePatient(id);
         return ResponseEntity.ok(HttpStatus.OK);

     }

     @GetMapping
    public Collection<PatientDto> getAllPatient(){
        return patientService.getAll();
     }


}
