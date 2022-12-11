package com.proyecto.clinica.service;

import com.proyecto.clinica.entity.TurnDto;

import java.util.Set;

public interface ITurnService {
    void createTurn(TurnDto turnDto);
    TurnDto readTurn(Long id);
    void changeTurn(TurnDto turnDto);
    void removeTurn(Long id);
    Set<TurnDto> getAll();
}
