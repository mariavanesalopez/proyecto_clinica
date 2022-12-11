package com.proyecto.clinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.clinica.entity.Dentist;
import com.proyecto.clinica.entity.DentistDto;
import com.proyecto.clinica.repository.IDentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistService implements IDentistService{
    @Autowired
    private IDentistRepository dentistRepository;
    @Autowired
    ObjectMapper mapper;

    private void saveDentist(DentistDto dentistDto){
        Dentist dentist = mapper.convertValue(dentistDto, Dentist.class);
        dentistRepository.save(dentist);

    }

    @Override
    public void createDentist(DentistDto dentistDto) {
        saveDentist(dentistDto);

    }

    @Override
    public DentistDto readDentist(Long id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDto dentistDto = null;
        if(dentist.isPresent())
            dentistDto = mapper.convertValue(dentist, DentistDto.class);
        return dentistDto;
    }

    @Override
    public void changeDentist(DentistDto dentistDto) {
        saveDentist(dentistDto);

    }

    @Override
    public void removeDentist(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public Set<DentistDto> getAll() {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<DentistDto> dentistDtos = new HashSet<>();
        for (Dentist dentist : dentists) {
            dentistDtos.add(mapper.convertValue(dentist, DentistDto.class));
        }
        return dentistDtos;
    }

}
