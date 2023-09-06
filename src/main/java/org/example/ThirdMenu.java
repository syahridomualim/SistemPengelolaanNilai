package org.example;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.Util.*;

public class ThirdMenu {

    private ThirdMenu() {
    }

    public static void printAllFile(Scanner scanner) {
        boolean isHome = false;

        while (!isHome) {
            showHeader();

            ExecutorService executor = Executors.newFixedThreadPool(2);

            executor.submit(Util::printModus);
            executor.submit(Util::printModusMedianMean);

            executor.shutdown();
            System.out.println("\nFile telah di generate di C://temp/direktori silahkan cek");

            isHome = isHomePage(scanner, isHome);
        }
    }

}
