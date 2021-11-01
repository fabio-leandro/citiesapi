package com.digitalinnovationone.citiesapi.services;


import com.digitalinnovationone.citiesapi.builders.CityBuilder;
import com.digitalinnovationone.citiesapi.entities.City;
import com.digitalinnovationone.citiesapi.repositories.CityRepository;
import static org.junit.jupiter.api.Assertions. *;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    @Test
    void whenCalledItshouldBeReturnedAListOfCities(){

        //given
        City city = CityBuilder.builder().build().toCity();
        List<City> cityListExpected = Collections.singletonList(city);

        //when
        Mockito.when(cityRepository.findAll()).thenReturn(List.of(city));

        //then
        List<City> cityListActual = cityService.listAll();

        assertEquals(cityListExpected,cityListActual);

    }

    @Test
    void whenCalledItShoudBeReturnedACity(){

        //given
        City city = CityBuilder.builder().build().toCity();
        City cityExpected = city;

        //when
        Mockito.when(cityRepository.findByName(city.getName())).thenReturn(city);

        //then
        City cityActual = cityService.findByName(city.getName());

        assertEquals(cityExpected,cityActual);

    }


}
