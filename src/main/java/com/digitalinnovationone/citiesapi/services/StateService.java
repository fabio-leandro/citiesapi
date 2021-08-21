package com.digitalinnovationone.citiesapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovationone.citiesapi.entities.State;
import com.digitalinnovationone.citiesapi.repositories.StateRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StateService {
	
	private final StateRepository stateRepository;
	
	public List<State> listAll() {
        List<State> state = stateRepository.findAll();
        return state;
    }
	
	public State findByUf(String uf) {
		State state = stateRepository.findByUf(uf);
		return state;
	}
	
}
