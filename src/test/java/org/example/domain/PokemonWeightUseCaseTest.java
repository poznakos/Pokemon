package org.example.domain;

import mock.RepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonWeightUseCaseTest {;

    PokemonWeightUseCase sut;

    @BeforeEach
    public void creatSUT() {
        RepositoryMock repositoryMock = new RepositoryMock();
        sut = new PokemonWeightUseCase(repositoryMock);
    }

    @Test
    void process_1() {
        assertEquals("abra Weight: 195", sut.process("Abra"));
    }
}