package com.digitalinnovationone.citiesapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<City> listAll(){
		return cityService.listAll();
	}
	
	@GetMapping("/{name}")
	public City findByName(@PathVariable String name) {
		return cityService.findByName(name);
	}

}
