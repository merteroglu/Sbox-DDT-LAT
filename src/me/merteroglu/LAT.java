package me.merteroglu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LAT {
    private int[][] LAT;
    private int[][] DOT;
    private int[][] sBox;
    private List<Integer> sBoxValues;
    private int size;

    public LAT(int size,String[][] sBox) {
        this.LAT = new int[size*size][size*size];
        fillArray(this.LAT);
        this.DOT = new int[size*size][size*size];
        fillArray(this.DOT);

        this.sBox = new int[size][size];
        this.sBoxValues = new ArrayList<>();
        this.size = size;

        for (int i = 0; i < sBox.length; i++) {
            for (int j = 0; j < sBox.length; j++) {
                this.sBox[i][j] = Integer.parseInt(sBox[i][j],16);
            }
        }

        calcSBoxVal();
        calcDOT();
        calcLAT();
    }

    private void fillArray(int[][] lat) {
        for (int i = 0; i < lat.length; i++) {
            Arrays.fill(lat[i],0);
        }
    }

    private void calcSBoxVal(){
        for (int i = 0; i < size*size; i++) {
            int col = i >> 4;
            int row = i & 15;
            sBoxValues.add(sBox[row][col]);
        }
    }

    private void calcDOT(){
        for (int i = 0; i < size * size; i++) {
            for (int j = 0; j < size * size; j++) {
                DOT[i][j] = latDot(i,j);
            }
        }
    }

    private void calcLAT(){
        for (int i = 0; i < size * size; i++) {
            for (int j = 0; j < size * size; j++) {
                for (int k = 0; k < size * size; k++) {
                    LAT[i][j] += DOT[i][k] ^ DOT[j][sBoxValues.get(k)];
                }
                LAT[i][j] = LAT[i][j] - 128;
            }
        }
    }

    private int latDot(int a,int b){
        boolean[] binary1 = convertToBinary(a);
        boolean[] binary2 = convertToBinary(b);
        int out = 0;

        if(binary1[0] && binary2[0])
            out = 1;

        for (int i = 1; i < 8; i++) {
            if(binary1[i] && binary2[i])
                out = out ^ 1;
            else
                out = out ^ 0;
        }

        return out;
    }

    private boolean[] convertToBinary(int b){
        boolean[] binArray = new boolean[8];
        boolean bin;
        for(int i = 7; i >= 0; i--) {
            if (b%2 == 1) bin = true;
            else bin = false;
            binArray[i] = bin;
            b/=2;
        }
        return binArray;
    }

    public void printSBox(){
        print(sBox);
    }

    public void printLAT(){
        print(LAT);
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
