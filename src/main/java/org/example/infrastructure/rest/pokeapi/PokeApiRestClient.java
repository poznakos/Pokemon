package org.example.infrastructure.rest.pokeapi;

import feign.Feign;
import feign.codec.StringDecoder;
import feign.gson.GsonDecoder;

public class PokeApiRestClient {

    public static PokeApiV2 getPokeApiV2(){
        return Feign.builder()
//                .decoder(new GsonDecoder())
                .decoder(new StringDecoder())
                .target(PokeApiV2.class, "https://pokeapi.co/api/v2");
    }

}
