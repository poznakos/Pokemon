package org.example.reposytory;

import mock.IRepositoryMock;
import mock.PokeApiV2Mock;
import org.example.domain.PokemonWeightUseCase;
import org.example.infrastructure.rest.pokeapi.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Repository sut;

    @BeforeEach
    public void creatSUT() {

        PokeApiV2Mock pokeApiV2Mock = new PokeApiV2Mock();

        sut = new Repository(pokeApiV2Mock);
    }

    @Test
    void getPokemon() {
        assertEquals("test name", sut.getPokemon("Pikachu").name);

    }
}