package org.example.interfaces;

import kotlin.Pair;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class AppInterface {

    @Getter
    private List<Pair<Integer, String>> results = new ArrayList<>();

    public abstract String getInput();

    public void setResult(Integer id, String result) {
        results.add(new Pair<>(id, result));
    }
}
