package com.digitalinnovationone.citiesapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
	@ResponseStatus(HttpStatus.OK)
	public List<State> listAll(){
		return stateService.listAll();
	}
	
	@GetMapping("/{uf}")
	@ResponseStatus(HttpStatus.OK)
	public State findByUf(@PathVariable String uf) {
		return stateService.findByUf(uf);
	}
	

}
