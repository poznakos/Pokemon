package org.example.interfaces;

import org.example.domain.PokemonWeightUseCase;
import org.example.infrastructure.rest.pokeapi.PokeApiRestClient;
import org.example.infrastructure.rest.pokeapi.PokeApiV2;
import org.example.reposytory.IRepository;
import org.example.reposytory.Repository;

import java.util.Scanner;

// warstawa widoku, pobieranie wyśietlanie danych userowi


public class Cli {
    PokeApiV2 pokeApiV2 = PokeApiRestClient.getPokeApiV2();
    IRepository reposytory = new Repository(pokeApiV2);

    PokemonWeightUseCase weight = new PokemonWeightUseCase(reposytory);
    public void run() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj imię pokemona");
        String name = scan.nextLine();

//        Pokemon pokemon = reposytory.getPokemon(name);
        String result = weight.process(name);

        System.out.println(result);

    }

}
