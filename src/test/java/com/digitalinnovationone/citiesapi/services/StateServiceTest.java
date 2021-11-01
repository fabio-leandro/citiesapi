package com.digitalinnovationone.citiesapi.services;

import com.digitalinnovationone.citiesapi.builders.StateBuilder;
import com.digitalinnovationone.citiesapi.entities.State;
import com.digitalinnovationone.citiesapi.repositories.StateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StateServiceTest {

    @Mock
    private StateRepository stateRepository;

    @InjectMocks
    private StateService stateService;

    @Test
    void whenCalledItshouldBeReturnedAListOfStates(){

        //given
        State state = StateBuilder.builder().build().toState();
        List<State> stateListExpected = Collections.singletonList(state);

        //when
        Mockito.when(stateRepository.findAll()).thenReturn(List.of(state));

        //then
        List<State> stateListActual = stateService.listAll();

        Assertions.assertEquals(stateListExpected,stateListActual);

    }

    @Test
    void whenCalledItshouldBeReturnedAState(){

        //given
        State state = StateBuilder.builder().build().toState();
        State stateExpected = state;

        //when
        Mockito.when(stateRepository.findByUf(state.getUf())).thenReturn(state);

        //then
        State stateActual = stateService.findByUf(state.getUf());
        Assertions.assertEquals(stateExpected,stateActual);
    }

}
