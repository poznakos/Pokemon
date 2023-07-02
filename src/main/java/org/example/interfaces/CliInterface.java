package org.example.interfaces;

import java.util.Scanner;

// warstawa widoku, pobieranie wyświetlanie danych userowi

public class CliInterface extends AppInterface {

    public static final String CLI_QUESTION = "Podaj identyfikator użytkownika";

    Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.println(CLI_QUESTION);
        return scanner.nextLine();
    }

}
