package org.example.domain;

import org.example.infrastructure.rest.pokeapi.Pokemon;
import org.example.reposytory.IRepository;

public class PokemonWeightUseCase implements IUseCase {

    IRepository reposytory;
    public PokemonWeightUseCase(IRepository reposytory) {
        this.reposytory = reposytory;
    }

    @Override
    public String process(String name) {
        Pokemon pokemon = reposytory.getPokemon(name);
        return pokemon.name + " Weight: " + pokemon.weight;

    }
}
