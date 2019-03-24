package me.merteroglu;

public class DDT extends Table {

    public DDT(String[][] sBox, int size, int bitSize) {
        super(sBox, size, bitSize);
    }

    @Override
    public void calc() {
        for (int i = 0; i <=size; i++) {
            for (int j = 0; j <= size; j++) {
                TABLE[i][j] = calcNumber(i,j);
            }
        }
    }

    @Override
    protected int calcNumber(int inputMask, int outputMask) {
        int total = 0;
        for (int i = 0; i <=size; i++) {
            String sx = intToString(Integer.parseInt(sBox[1][i],16),bitSize);
            String sx2 = sBox[1][i ^ inputMask];
            int i1 = Integer.parseInt(sx, 2) ^ Integer.parseInt(sx2, 16);

            if(i1 == outputMask)
                total++;

        }

        return total;
    }
}
