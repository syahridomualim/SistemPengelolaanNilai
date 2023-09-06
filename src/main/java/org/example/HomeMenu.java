package org.example;

public class HomeMenu {
    public static void displayHomeMenu() {
        Util.showHeader();

        System.out.println();
        System.out.println("Letakan file csv dengan nama file data_sekolah di directory berikut: C://temp/direktori");

        System.out.println();
        System.out.println("Pilih menu: ");
        System.out.println("1. Generate text untuk menampilkan modus");
        System.out.println("2. Generate text untuk menampilkan nilai rata-rata, median");
        System.out.println("3. Generate kedua file");
        System.out.println("0. Exit");
        System.out.println();
    }
}
