package org.example;

import com.google.gson.Gson;
import kotlin.Pair;
import org.example.infrastructure.rest.usersbooks.ResourceLoader;
import org.example.infrastructure.rest.usersbooks.UserBooksApi;
import org.example.infrastructure.rest.usersbooks.UserBooksApiMock;
import org.example.interfaces.UnitTestInterface;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("UT")
public class AppUT {

    @Test
    public void runAppButOnMocks(){
        // GIVEN
        UserBooksApiMock userBooksApiMock = new UserBooksApiMock();

        var appInput = new UnitTestInterface(0);

        // WHEN
        new AppRunner(userBooksApiMock).run(appInput);

        // THEN
        List<Pair<Integer, String>> results = appInput.getResults();
        String userWithBooks = results.get(0).getSecond();
        userWithBooks.toString();
    }
}
