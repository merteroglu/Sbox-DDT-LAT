package me.merteroglu;

public abstract class Table {
    protected String[][] sBox;
    protected int[][] TABLE;
    protected int size;
    protected int bitSize;

    public Table(String[][] sBox, int size, int bitSize) {
        this.sBox = sBox;
        this.size = size;
        this.bitSize = bitSize;
        this.TABLE = new int[size+1][size+1];
        calc();
    }

    public abstract void calc();
    protected abstract int calcNumber(int inputMask, int outputMask);

    public String intToString(int number, int groupSize) {
        StringBuilder result = new StringBuilder();

        for(int i = bitSize-1; i >= 0 ; i--) {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");

            if (i % groupSize == 0)
                result.append(" ");
        }
        result.replace(result.length() - 1, result.length(), "");

        return result.toString();
    }

    public void printTable(){
        System.out.println();
        for (int i = 0; i < TABLE.length; i++) {
            for (int j = 0; j < TABLE.length; j++) {
                System.out.print(TABLE[i][j] + "\t");
            }
            System.out.println();
        }
    }

    protected int xorArr(char[] toCharArray) {
        String newBitArr = "";
        for (int i = 0; i < toCharArray.length; i+=2) {
            int xor = Integer.parseInt(String.valueOf(toCharArray[i]))  ^ Integer.parseInt(String.valueOf(toCharArray[i+1]));
            newBitArr += String.valueOf(xor);
        }
        if(toCharArray.length % 2 != 0)
            newBitArr += toCharArray[toCharArray.length-1];

        if(newBitArr.length() == 1)
            return Integer.parseInt(newBitArr);
        else
            return xorArr(newBitArr.toCharArray());
    }


}
