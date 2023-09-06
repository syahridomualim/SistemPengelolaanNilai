package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Util {

    private static final String FILE_NAME = "E:\\Document\\IDP\\java-level-3\\SistemPengelolaanNilai\\src\\main\\resources\\data_sekolah.csv";

    public static void showHeader() {
        System.out.println("--------------------------------");
        System.out.println("Aplikasi Pengelolaan Nilai Siswa");
        System.out.println("--------------------------------");
        System.out.println();
    }

    public static void displayMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Kembali ke menu utama");
        System.out.println();
    }

    public static void printModus() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            Map<Integer, Integer> frequencyValueMap = new HashMap<>();
            String line;
            // retrieve nilai dari csv
            while ((line = reader.readLine()) != null) {
                // convert to string array
                String[] data = line.split(";");
                for (int i = 1; i < data.length; i++) {
                    int value = Integer.parseInt(data[i]);
                    frequencyValueMap.put(value, frequencyValueMap.getOrDefault(value, 0) + 1);
                }
            }

            PrintStream o = new PrintStream("C:\\temp\\direktori\\dataModus.txt");
            PrintStream console = System.out;
            System.setOut(o);

            System.out.println("Berikut Hasil Pengolahan Nilai:\n");
            System.out.println("Nilai\t\t\t\t| Frekuensi");
            System.out.println("kurang dari 6\t\t\t| " + frequencyValueMap.getOrDefault(5, 0));
            for (int i = 6; i <= 10; i++) {
                System.out.println(i + "\t\t\t\t| " + frequencyValueMap.getOrDefault(i, 0));
            }

            System.setOut(console);
        } catch (FileNotFoundException exception) {
            System.out.println("File does not exist");
        } catch (IOException exception) {
            System.out.println("Error reading file");
        }
    }

    public static void printModusMedianMean() {

        List<Integer> allData = new ArrayList<>();
        Map<Integer, Integer> frequencyValueMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                for (int i = 1; i < data.length; i++) {
                    int value = Integer.parseInt(data[i]);
                    allData.add(value);
                    frequencyValueMap.put(value, frequencyValueMap.getOrDefault(value, 0) + 1);
                }
            }

            double mean = countMean(allData);
            double median = countMedian(allData);
            int modus = showModus(frequencyValueMap);

            // print to text document
            PrintStream o = new PrintStream("C:\\temp\\direktori\\dataModusMedianMean.txt");
            PrintStream console = System.out;
            System.setOut(o);

            System.out.println("Berikut Hasil Pengolahan Nilai:\n");
            System.out.println("Berikut hasil sebaran data nilai");
            System.out.println("Mean\t\t\t: " + mean);
            System.out.println("Median\t\t\t: " + median);
            System.out.println("Modus\t\t\t: " + modus);

            System.setOut(console);
        } catch (FileNotFoundException exception) {
            System.out.println("File does not exist");

        } catch (IOException exception) {
            System.out.println("Error reading file");
        }
    }

    static boolean isHomePage(Scanner scanner, boolean isHomePage) {
        Util.displayMenu();
        int input = scanner.nextInt();
        switch (input) {
            case 1: {
                isHomePage = true;
                break;
            }
            case 0: {
                scanner.close();
                System.exit(0);
                break;
            }
            default:
                System.out.println("Menu tidak ada, silahkan masukkan 1 atau 0");
        }
        return isHomePage;
    }

    static double countMean(List<Integer> data) {
        // count mean
        return data.stream().mapToDouble(Integer::doubleValue)
                .average().orElse(0);
    }

    static double countMedian(List<Integer> data) {
        // sorting data
        List<Integer> sortedData = data.stream().sorted().collect(Collectors.toList());
        int n = sortedData.size();
        double median;
        if (n % 2 == 0) {
            // misal n = 10, berarti nilai ke 4 + nilai ke 5 kemudian dibagi 2.0
            median = (sortedData.get(n / 2 - 1) + sortedData.get(n / 2)) / 2.0;
        } else {
            // misal n = 9, berarti ke 9 kemudian dibagi 2
            median = sortedData.get(n / 2);
        }

        return median;
    }

    static int showModus(Map<Integer, Integer> frequencyValueMap) {
        return frequencyValueMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(0);
    }
}
