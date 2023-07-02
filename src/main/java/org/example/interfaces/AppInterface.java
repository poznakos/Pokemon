package org.example.interfaces;

import kotlin.Pair;
import lombok.Getter;
import org.example.domain.UserWithBooksDetailed;

import java.util.ArrayList;
import java.util.List;

public abstract class AppInterface {

    @Getter
    private List<Pair<Integer, UserWithBooksDetailed>> results = new ArrayList<>();

    public abstract String getInput();

    public void setResult(Integer id, UserWithBooksDetailed userWithBooksDetailed) {
        results.add(new Pair<>(id, userWithBooksDetailed));
    }
}
