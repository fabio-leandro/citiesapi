package com.digitalinnovationone.citiesapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalinnovationone.citiesapi.entities.City;
import com.digitalinnovationone.citiesapi.repositories.CityRepository;

@Service
public class CityService {
	
	private final CityRepository cityRepository;
	
	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	
	public List<City> listAll(){
		List<City> city = cityRepository.findAll();
		return city;
	}
	
	public City findByName(String name) {
		City city = cityRepository.findByName(name);
		return city;
	}
	
	
	
}
