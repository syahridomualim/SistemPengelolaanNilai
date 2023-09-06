package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        showMainMenu(scanner, isExit);
    }

    private static void showMainMenu(Scanner scanner, boolean isExit) {
        while (!isExit) {

            org.example.HomeMenu.displayHomeMenu();

            int input = scanner.nextInt();
            switch (input) {
                case 1: {
                    org.example.FirstMenu.printModus(scanner);
                    break;
                }
                case 2: {
                    org.example.SecondMenu.printModusMeanMedian(scanner);
                    break;
                }
                case 3: {
                    org.example.ThirdMenu.printAllFile(scanner);
                    break;
                }
                case 0: {
                    isExit = true;
                    scanner.close();
                    break;
                }
                default:
                    System.out.println("Menu doesn't exist'");
            }
        }
    }
}