package org.example;

import java.util.Scanner;

import static org.example.Util.isHomePage;

public class FirstMenu {

    private FirstMenu() {
    }

    public static void printModus(Scanner scanner) {
        boolean isHomePage = false;

        while (!isHomePage) {
            Util.showHeader();

            Util.printModus();
            System.out.println("\nFile telah di generate di C://temp/direktori silahkan cek");

            isHomePage = isHomePage(scanner, isHomePage);
        }
    }

}
