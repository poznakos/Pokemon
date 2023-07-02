package org.example;

import org.example.infrastructure.rest.usersbooks.UserBooksApi;
import org.example.infrastructure.rest.usersbooks.UsersBooksApiRestClient;
import org.example.interfaces.CliInterface;

public class Main {

    public static void main(String[] args) {
        UserBooksApi usersBooks = UsersBooksApiRestClient.getUsersBooks("http://localhost:8089");
        AppRunner appRunner = new AppRunner(usersBooks);

        CliInterface appInput = new CliInterface();
        appRunner.run(appInput);
    }

}
