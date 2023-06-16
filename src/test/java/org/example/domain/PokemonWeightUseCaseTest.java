package org.example.domain;

import mock.IRepositoryMock;
import org.example.infrastructure.rest.pokeapi.Pokemon;
import org.example.reposytory.IRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonWeightUseCaseTest {;

    PokemonWeightUseCase sut;

    @BeforeEach
    public void creatSUT() {
        IRepository repositoryMock = new IRepositoryMock();
        sut = new PokemonWeightUseCase(repositoryMock);
    }

    @Test
    void process_1() {
        assertEquals("test name Weight: 0", sut.process("xxx"));
    }
}