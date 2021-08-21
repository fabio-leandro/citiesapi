package com.digitalinnovationone.citiesapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovationone.citiesapi.entities.State;
import com.digitalinnovationone.citiesapi.services.StateService;

@RestController
@RequestMapping("/api/v1/states")
public class StateController {
	
	private final StateService stateService;
	
	public StateController(StateService stateService) {
		this.stateService = stateService;
	}
	
	@GetMapping
	public List<State> listAll(){
		return stateService.listAll();
	}
	
	@GetMapping("/{uf}")
	public State findByUf(@PathVariable String uf) {
		return stateService.findByUf(uf);
	}
	

}
