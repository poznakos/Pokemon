package org.example.interfaces;

import org.example.domain.UsersBooksService;

import java.util.Scanner;

// warstawa widoku, pobieranie wyświetlanie danych userowi

public class Cli {

    private final UsersBooksService usersBooksService = new UsersBooksService();

    public void run() {

//        Scanner scan = new Scanner(System.in);
//        System.out.println("Podaj imię pokemona");
//        String name = scan.nextLine();

        usersBooksService.getUserBooks(1);

    }

}
