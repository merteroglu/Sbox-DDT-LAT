package me.merteroglu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size :");
        int size = scn.nextInt();
        System.out.println("Print sBox (Hex)");
        String[][] sBox = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("Enter the [%d,%d] : ",i,j);
                sBox[i][j] = scn.next();
            }
        }

        DDT ddt = new DDT(size,sBox);
        //ddt.printDDT();

        LAT lat = new LAT(size,sBox);
        lat.printLAT();

    }
}
