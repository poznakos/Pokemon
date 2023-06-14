package org.example.domain;

import org.example.infrastructure.rest.pokeapi.PokeApiV2;
import org.example.infrastructure.rest.pokeapi.Pokemon;
import org.example.reposytory.Repository;
import org.example.reposytory.Reposytory;

import java.util.Scanner;

public class PokemonWeightUseCase {

    Repository reposytory;
    public PokemonWeightUseCase(Repository reposytory) {
        this.reposytory = reposytory;
    }

    public String process(String name) {
        Pokemon pokemon = reposytory.getPokemon(name);
        return pokemon.name + " Weight: " + pokemon.weight;

    }
}
