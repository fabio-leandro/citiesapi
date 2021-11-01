package com.digitalinnovationone.citiesapi.builders;

import com.digitalinnovationone.citiesapi.entities.State;
import lombok.Builder;

@Builder
public class StateBuilder {

    @Builder.Default
    private Long id = 11L;
    @Builder.Default
    private String stateName = "Minas Gerais";
    @Builder.Default
    private String uf = "MG";
    @Builder.Default
    private int ibgeCode = 31;
    @Builder.Default
    private String country = "BR";
    @Builder.Default
    private String ddd = "34,37,31,33,35,38,32";


    public State toState(){
        return new State(id, stateName, uf, ibgeCode, country, ddd);
    }


}
