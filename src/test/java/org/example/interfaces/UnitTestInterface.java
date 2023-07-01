package org.example.interfaces;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnitTestInterface extends AppInterface {

    private final int input;

    @Override
    public String getInput() {
        return String.valueOf(input);
    }
}
