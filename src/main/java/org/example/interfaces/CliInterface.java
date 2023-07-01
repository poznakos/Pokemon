package org.example.interfaces;

import java.util.Scanner;

// warstawa widoku, pobieranie wyświetlanie danych userowi

public class CliInterface extends AppInterface {

    Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.println("Podaj identyfikator użytkownika");
        return scanner.nextLine();
    }

}
