package org.example;

import org.example.domain.UserWithBooksDetailed;
import org.example.infrastructure.rest.usersbooks.UserBooksApiMock;
import org.example.interfaces.UnitTestInterface;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UT")
public class AppUT {

    @Test
    public void runAppButOnMocks(){
    // GIVEN
        // - Mock
        UserBooksApiMock userBooksApiMock = new UserBooksApiMock();
        // - Fake interface
        var appInput = new UnitTestInterface(0);

    // WHEN
        new AppRunner(userBooksApiMock).run(appInput);

    // THEN
        UserWithBooksDetailed userWithBooks = appInput.getResults().get(0).getSecond();
        // - Assertions
        userWithBooks.toString();
    }

}
