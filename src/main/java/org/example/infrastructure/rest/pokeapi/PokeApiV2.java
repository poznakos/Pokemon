package org.example.infrastructure.rest.pokeapi;

import feign.Param;
import feign.RequestLine;

public interface PokeApiV2 {

    @RequestLine("GET /pokemon/{pokemonName}")
    String getPokemon(@Param("pokemonName") String pokemonName);

}
