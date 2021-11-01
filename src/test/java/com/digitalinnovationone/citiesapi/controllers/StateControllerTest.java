package com.digitalinnovationone.citiesapi.controllers;

import com.digitalinnovationone.citiesapi.builders.StateBuilder;
import com.digitalinnovationone.citiesapi.entities.State;
import com.digitalinnovationone.citiesapi.services.StateService;
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

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

@ExtendWith(MockitoExtension.class)
public class StateControllerTest {

    @Mock
    private StateService stateService;

    @InjectMocks
    private StateController stateController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(stateController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView()).build();
    }

    @Test
    void whenCalledItShouldBeReturnedStatusHttpOk() throws Exception {
        //given
        State state = StateBuilder.builder().build().toState();

        //when
        Mockito.when(stateService.listAll()).thenReturn(List.of(state));

        //then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/states")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(equalTo(state.getId().intValue()))))
                .andExpect(jsonPath("$[0].ibgeCode",is(equalTo(state.getIbgeCode()))));

    }

    @Test
    void whenCalledItShouldBeReturnedHttpStatusOk() throws Exception {

        //given
        State state = StateBuilder.builder().build().toState();
        String statePesquisado = "MG";

        //when
        Mockito.when(stateService.findByUf(state.getUf())).thenReturn(state);

        //then
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/states/"+statePesquisado)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(equalTo(state.getId().intValue()))))
                .andExpect(jsonPath("$.ibgeCode", is(equalTo(state.getIbgeCode()))));
    }

}
