package mock;

import org.example.infrastructure.rest.pokeapi.PokeApiV2;

public class PokeApiV2Mock implements PokeApiV2 {


    @Override
    public String getPokemon(String pokemonName) {
        return "{name: \"test name\"}";
    }
}
