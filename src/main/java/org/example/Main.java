package org.example;

import org.example.infrastructure.rest.usersbooks.UserBooksApi;
import org.example.infrastructure.rest.usersbooks.UsersBooksApiRestClient;
import org.example.infrastructure.rest.usersbooks.UsersBooksServiceStreamOptimized;
import org.example.interfaces.CliInterface;

public class Main {

    public static void main(String[] args) {

        UserBooksApi usersBooks = UsersBooksApiRestClient.getUsersBooks();
        AppRunner appRunner = new AppRunner(usersBooks);

        CliInterface appInput = new CliInterface();
        appRunner.run(appInput);

    }
}
