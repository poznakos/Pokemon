package mock;

import org.example.infrastructure.rest.pokeapi.Pokemon;
import org.example.reposytory.IRepository;

public class IRepositoryMock implements IRepository {

    @Override
    public Pokemon getPokemon(String name) {
        Pokemon pokemon = new Pokemon();
        pokemon.name = "test name";
        return pokemon;
    }
}
