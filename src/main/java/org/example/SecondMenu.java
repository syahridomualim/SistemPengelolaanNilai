package org.example;

import java.util.Scanner;

import static org.example.Util.*;

public class SecondMenu {

    private SecondMenu(){
    }
    public static void printModusMeanMedian(Scanner scanner) {
        boolean isHomePage = false;

        while (!isHomePage) {
            showHeader();

            printModusMedianMean();
            System.out.println("\nFile telah di generate di C://temp/direktori silahkan cek");
            isHomePage = isHomePage(scanner, isHomePage);
        }
    }
}
