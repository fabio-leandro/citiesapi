package com.digitalinnovationone.citiesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalinnovationone.citiesapi.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
	City findByName(String name);

}
