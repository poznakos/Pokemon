package org.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonWeightUseCaseTest {;

    PokemonWeightUseCase sut;

    @BeforeEach
    public void creatSUT() {
//        sut = new PokemonWeightUseCase();
    }

    @Test
    void process_1() {
        assertEquals("abra Weight: 195", sut.process("Abra"));
    }
}