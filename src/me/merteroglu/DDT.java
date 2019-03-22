package me.merteroglu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DDT {
    private int[][] DDT;
    private int[][] sBox;
    private List<Integer> sBoxValues;
    private int size;

    public DDT(int size,String[][] sBox) {
        this.DDT = new int[size*size][size*size];
        fillDDT();

        this.sBox = new int[size][size];
        this.sBoxValues = new ArrayList<>();
        this.size = size;

        for (int i = 0; i < sBox.length; i++) {
            for (int j = 0; j < sBox.length; j++) {
                this.sBox[i][j] = Integer.parseInt(sBox[i][j],16);
            }
        }

        calcSBoxVal();
        calcDDT();
    }

    private void calcSBoxVal(){
        for (int i = 0; i < size*size; i++) {
            int col = i >> 4;
            int row = i & 15;
            sBoxValues.add(sBox[row][col]);
        }
    }

    private void calcDDT(){
        for (int i = 0; i < size*size; i++) {
            for (int j = 0; j < size*size; j++) {
                int xorIn = i ^ j;
                int xorOut = sBoxValues.get(i) ^ sBoxValues.get(j);
                DDT[xorIn][xorOut] += 1;
            }
        }
    }

    private void fillDDT(){
        for (int i = 0; i < DDT.length; i++) {
            Arrays.fill(DDT[i],0);
        }
    }

    public void printSBox(){
        print(sBox);
    }

    public void printDDT(){
        print(DDT);
    }

    public void printSBoxValues(){
        print(sBoxValues);
    }

    private void print(int[][] mat){
        System.out.println();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void print(List<Integer> arr){
        System.out.println();
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + "\t");
        }
        System.out.println();
    }


}
