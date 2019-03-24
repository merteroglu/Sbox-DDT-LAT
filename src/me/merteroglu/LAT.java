package me.merteroglu;



public class LAT extends Table{

    public LAT(String[][] sBox, int size, int bitSize) {
        super(sBox, size, bitSize);
    }

    @Override
    public void calc(){
        for (int i = 0; i <=size; i++) {
            for (int j = 0; j <= size; j++) {
                TABLE[i][j] = calcNumber(i,j) - ((int)Math.pow(2,bitSize-1));
            }
        }
    }


    @Override
    protected int calcNumber(int inputMask, int outputMask) {
        int total = 0;
        for (int i = 0; i <= size; i++) {
            String multipInput = multipArr(intToString(inputMask,bitSize).toCharArray(),
                    intToString(Integer.parseInt(sBox[0][i],16),bitSize).toCharArray());

            String multipOutput = multipArr(intToString(outputMask,bitSize).toCharArray(),
                    intToString(Integer.parseInt(sBox[1][i],16),bitSize).toCharArray());

            int xorInput = xorArr(multipInput.toCharArray());
            int xorOutput = xorArr(multipOutput.toCharArray());
            if(xorInput == xorOutput)
                total++;
        }

        return total;
    }

    private String multipArr(char[] chrArr, char[] chrArr2) {
        String newStr = "";
        for (int i = 0; i < chrArr.length; i++) {
            int v1 = Integer.parseInt(String.valueOf(chrArr[i]));
            int v2 = Integer.parseInt(String.valueOf(chrArr2[i]));
            newStr += (v1 * v2);
        }

        return newStr;
    }






}
