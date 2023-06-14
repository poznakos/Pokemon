package org.example.interfaces;

import org.example.domain.PokemonWeightUseCase;
import org.example.infrastructure.rest.pokeapi.Pokemon;
import org.example.reposytory.Repository;
import org.example.reposytory.Reposytory;

import java.util.Scanner;

// warstawa widoku, pobieranie wyśietlanie danych userowi


public class Cli {

    Repository reposytory = new Reposytory();

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
