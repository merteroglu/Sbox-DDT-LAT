package me.merteroglu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the bit size :");
        int bitSize = scn.nextInt();
        String bitString = "";
        for (int i = 0; i < bitSize; i++) {
            bitString += "1";
        }

        int size = Integer.parseInt(bitString,2);
        String[][] sBox = new String[2][size+1];
        for (int i = 0; i <= size; i++) {
            sBox[0][i] = Integer.toHexString(i);
            System.out.printf("Enter %s :",sBox[0][i]);
            sBox[1][i] = scn.next();
        }

        //LAT lat = new LAT(sBox,size,bitSize);
        //lat.printTable();

        DDT ddt = new DDT(sBox,size,bitSize);
        ddt.printTable();

    }



}
