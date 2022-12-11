package com.proyecto.clinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.clinica.entity.Patient;
import com.proyecto.clinica.entity.PatientDto;
import com.proyecto.clinica.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientService implements IPatientService{
    @Autowired
    private IPatientRepository patientRepository;
    @Autowired
    ObjectMapper mapper;


    private void savePatient(PatientDto patientDto){
        Patient patient = mapper.convertValue(patientDto, Patient.class);
        patientRepository.save(patient);

    }
    @Override
    public void createPatient(PatientDto patientDto) {
        savePatient(patientDto);

    }

    @Override
    public PatientDto readPatient(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDto patientDto = null;
        if(patient.isPresent())
            patientDto = mapper.convertValue(patient, PatientDto.class);
        return patientDto;
    }

    @Override
    public void changePatient(PatientDto patientDto) {
        savePatient(patientDto);
    }

    @Override
    public void removePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Set<PatientDto> getAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDto> patientDtos = new HashSet<>();
        for (Patient patient : patients) {
            patientDtos.add(mapper.convertValue(patient, PatientDto.class));
        }
        return patientDtos;
    }
}
