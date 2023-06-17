package org.example.interfaces;

import org.example.domain.UserWithBooksDetailed;
import org.example.infrastructure.rest.usersbooks.UsersBooksServiceStreamOptimized;
import org.example.infrastructure.rest.usersbooks.UsersBooksServiceTraditional;

// warstawa widoku, pobieranie wyświetlanie danych userowi

public class Cli {

    private final UsersBooksServiceTraditional usersBooksServiceTraditional = new UsersBooksServiceTraditional();
    private final UsersBooksServiceStreamOptimized usersBooksServiceStreamOptimized = new UsersBooksServiceStreamOptimized();

    public void run() {

//        Scanner scan = new Scanner(System.in);
//        System.out.println("Podaj imię pokemona");
//        String name = scan.nextLine();

        UserWithBooksDetailed userBooksTraditional = usersBooksServiceTraditional.getUserBooks(1);
        UserWithBooksDetailed userBooksStream = usersBooksServiceStreamOptimized.getUserBooks(1);

        userBooksTraditional.toString();

    }

}
