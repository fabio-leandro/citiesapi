package com.digitalinnovationone.citiesapi.builders;

import com.digitalinnovationone.citiesapi.entities.City;
import com.digitalinnovationone.citiesapi.entities.State;
import lombok.Builder;

@Builder
public class CityBuilder {

    private static final Long STATE_ID = 2L;
    private static final String STATE_NAME = "Minas Gerais";
    private static final String STATE_UF = "MG";
    private static final int STATE_IBGE_CODE = 31;
    private static final String STATE_COUNTRY = "BR";
    private static final String STATE_DDD = "34,37,31,33,35,38,32";

    @Builder.Default
    private Long id = 1L;
    @Builder.Default
    private String name = "Belo Horizonte";
    @Builder.Default
    private State state = new State(STATE_ID,STATE_NAME,STATE_UF,STATE_IBGE_CODE,STATE_COUNTRY,STATE_DDD);
    @Builder.Default
    private String ibge = "3106200";

    public City toCity(){
        return new City(id,name,state,ibge);
    }

}
