package org.example.infrastructure.rest.usersbooks;

import feign.Param;
import feign.RequestLine;

public interface UserBooksApi {

    @RequestLine("GET /pokemon/{pokemonName}")
    String getPokemon(@Param("pokemonName") String pokemonName);

}
