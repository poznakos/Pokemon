package org.example.reposytory;

import org.example.infrastructure.rest.pokeapi.Pokemon;

public interface IRepository {
    Pokemon getPokemon(String name) ;
}
