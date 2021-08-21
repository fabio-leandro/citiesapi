package com.digitalinnovationone.citiesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalinnovationone.citiesapi.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {
	
	State findByUf(String uf);

}
