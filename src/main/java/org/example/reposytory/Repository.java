package org.example.reposytory;

import com.google.gson.Gson;
import org.example.infrastructure.rest.pokeapi.PokeApiRestClient;
import org.example.infrastructure.rest.pokeapi.PokeApiV2;
import org.example.infrastructure.rest.pokeapi.Pokemon;
import java.util.Locale;

//pobranie wymaganych danych
public class Repository implements IRepository {
    PokeApiV2 pokeApiV2;

    public Repository(PokeApiV2 pokeApiV2){
        this.pokeApiV2 = pokeApiV2;
    }

    @Override
    public Pokemon getPokemon(String name){
//        pokeApiV2 = PokeApiRestClient.getPokeApiV2();
        String pokemonResponse = null;
        try {
            pokemonResponse = pokeApiV2.getPokemon(name.toLowerCase(Locale.ROOT));
        } catch(Exception e) {
            System.out.println("cos poszlo nie tak!!!");
        }

        Gson gson = new Gson();

        Pokemon pokemon = gson.fromJson(pokemonResponse, Pokemon.class);

        return  pokemon;
    }

}
