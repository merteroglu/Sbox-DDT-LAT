package me.merteroglu;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("0 - Create S-Box Manual");
        System.out.println("1 - Create S-Box Auto");
        System.out.print("Selection : ");
        Scanner scn = new Scanner(System.in);
        int select = scn.nextInt();

        switch (select){
            case 0:
                manual();
                break;
            case 1:
                auto();
                break;
                default:
                    System.out.println("Only enter 0 or 1");
                    break;
        }
    }

    private static void manual(){
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

        printLatDTT(sBox,size,bitSize);
    }

    private static void auto(){
        GF gf = new GF();
        for (String s : gf.getListGF()) {
            System.out.println(s);
        }
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the select :");
        int select = scn.nextInt();

        gf.selectGF(select);
        System.out.print("Mapping x -> x^? : ");
        int mapping = scn.nextInt();

        gf.createMapping(mapping);

        gf.createSBox();

        String[][] sBox = gf.getsBox();
        System.out.println("\n\nS-Box");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 16; j++) {
                if(i == 0)
                    System.out.print(Integer.toHexString(j) + "  ");
                else
                    System.out.print(sBox[i][j] + "  ");
            }
            System.out.println("");
        }

        printLatDTT(sBox,15,4);
    }

    private static void printLatDTT(String[][] sBox,int size,int bitSize){
        System.out.println("\n ---- LAT ---- ");

        LAT lat = new LAT(sBox,size,bitSize);
        lat.printTable();

        System.out.println("\n\nNLM : " + lat.getNLM());

        System.out.println("\n\nNLMmax : " + lat.getNLM_MAX());

        System.out.println("\n\nNLM Percent : " + lat.getPercent());

        System.out.println("\n\n");

        System.out.println(" ---- DDT ---- ");

        DDT ddt = new DDT(sBox,size,bitSize);
        ddt.printTable();

    }

}
