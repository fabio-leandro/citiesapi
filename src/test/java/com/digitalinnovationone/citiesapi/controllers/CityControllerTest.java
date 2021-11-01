package com.digitalinnovationone.citiesapi.controllers;

import com.digitalinnovationone.citiesapi.builders.CityBuilder;
import com.digitalinnovationone.citiesapi.entities.City;
import com.digitalinnovationone.citiesapi.services.CityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@ExtendWith(MockitoExtension.class)
public class CityControllerTest {

    @Mock
    private CityService cityService;

    @InjectMocks
    private CityController cityController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(cityController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView()).build();
    }

    @Test
    void whenCalledItShouldBeReturnedStatusHttpOk() throws Exception {

        //given
        City city = CityBuilder.builder().build().toCity();

        //when
        Mockito.when(cityService.listAll()).thenReturn(Collections.singletonList(city));

        //then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cities")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(equalTo(city.getId().intValue()))))
                .andExpect(jsonPath("$[0].state.id", is(equalTo(city.getState().getId().intValue()))));

    }

    @Test
    void whenCalledItShouldBeReturnedHttpStatusOk() throws Exception {

        //given
        City city = CityBuilder.builder().build().toCity();
        String cidadePesquisada = "Belo Horizonte";

        //when
        Mockito.when(cityService.findByName(city.getName())).thenReturn(city);

        //then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cities/"+cidadePesquisada)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(equalTo(city.getId().intValue()))))
                .andExpect(jsonPath("$.state.id", is(equalTo(city.getState().getId().intValue()))));
    }



}
