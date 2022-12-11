package com.proyecto.clinica.service;

import com.proyecto.clinica.entity.PatientDto;

import java.util.Set;

public interface IPatientService {
    void createPatient(PatientDto patientDto);
    PatientDto readPatient(Long id);
    void changePatient(PatientDto patientDto);
    void removePatient(Long id);
    Set<PatientDto> getAll();
}
