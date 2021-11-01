package com.digitalinnovationone.citiesapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.digitalinnovationone.citiesapi.entities.City;
import com.digitalinnovationone.citiesapi.services.CityService;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {
	
	private final CityService cityService;
	
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<City> listAll(){
		return cityService.listAll();
	}
	
	@GetMapping("/{name}")
	@ResponseStatus(HttpStatus.OK)
	public City findByName(@PathVariable String name) {
		return cityService.findByName(name);
	}

}
