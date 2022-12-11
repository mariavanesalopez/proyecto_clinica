package com.proyecto.clinica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.clinica.entity.Turn;
import com.proyecto.clinica.entity.TurnDto;
import com.proyecto.clinica.repository.ITurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnService implements ITurnService{
    @Autowired
    private ITurnRepository turnRepository;
    @Autowired
    ObjectMapper mapper;

    private void saveTurn(TurnDto turnDto){
        Turn turn = mapper.convertValue(turnDto, Turn.class);
        turnRepository.save(turn);

    }

    @Override
    public void createTurn(TurnDto turnDto) {
        saveTurn(turnDto);
    }

    @Override
    public TurnDto readTurn(Long id) {
        Optional<Turn> turn = turnRepository.findById(id);
        TurnDto turnDto = null;
        if(turn.isPresent())
            turnDto = mapper.convertValue(turn, TurnDto.class);
        return turnDto;
    }

    @Override
    public void changeTurn(TurnDto turnDto) {
        saveTurn(turnDto);
    }

    @Override
    public void removeTurn(Long id) {
        turnRepository.deleteById(id);
    }

    @Override
    public Set<TurnDto> getAll() {
        List<Turn> turns = turnRepository.findAll();
        Set<TurnDto> turnDtos = new HashSet<>();
        for (Turn turn: turns){
            turnDtos.add(mapper.convertValue(turn, TurnDto.class));
        }
        return turnDtos;
    }

}
