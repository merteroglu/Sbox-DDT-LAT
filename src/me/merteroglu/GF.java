package me.merteroglu;

import java.util.ArrayList;

public class GF {

    private ArrayList<String> listGF;
    private ArrayList<Integer> intList;
    private ArrayList<String> bitList;
    private ArrayList<String> hexList;
    private ArrayList<Integer> mappingList;
    private String[][] sBox;
    private int consXor = 0;

    public GF() {
        listGF = new ArrayList<>();
        intList = new ArrayList<>();
        bitList = new ArrayList<>();
        hexList = new ArrayList<>();
        mappingList = new ArrayList<>();
        sBox = new String[2][16];
        initList();
    }

    private void initList() {
        listGF.add("0 - (x^4) + x + 1");
        listGF.add("1 - (x^4) + (x^3) + 1");
        listGF.add("2 - (x^4) + (x^3) + (x^2) + x + 1");
    }


    public void selectGF(int select){
        switch (select){
            case 0:
                consXor = 19;
                break;
            case 1:
                consXor = 25;
                break;
            case 2:
                consXor = 31;
                break;
        }
        createIntList();
    }

    private void createIntList() {
        int value = 1;
        for (int i = 1; i < 16; i++) {
            value = value << 1;

            if(Integer.toBinaryString(value).length() > 4){
                value = value ^ consXor;
            }

            intList.add(value);
        }
        createBitList();
    }

    private void createBitList() {
        for(Integer i : intList){
            bitList.add(intToString(i,4));
        }
        createHexList();
    }

    private void createHexList() {
        for(Integer i : intList){
            hexList.add(Integer.toHexString(i));
        }
    }

    public void createMapping(int map){
        int mapped = map;
        for (int i = 1; i < 16; i++) {
            if(mapped < 0)
                mapped += 15;
            if(mapped >= 15)
                mapped -= 15;

            mappingList.add(mapped);

            mapped += map;

        }
    }

    public void createSBox(){
        sBox[0][0] = Integer.toHexString(0);
        sBox[1][0] = Integer.toHexString(0);
        sBox[0][1] = Integer.toHexString(1);
        sBox[1][1] = Integer.toHexString(1);

        for (int i = 2; i < 16; i++) {
            sBox[0][i] = Integer.toHexString(i);
            int index = getIntListIndex(i);
            int mapValue = mappingList.get(index);
            sBox[1][i] = Integer.toHexString(intList.get(mapValue -1));
        }
    }

    private int getIntListIndex(int number){
        int index = -1;
        for (int i = 0; i < intList.size(); i++) {
            if(intList.get(i) == number){
                index = i;
                return index;
            }
        }
        return index;
    }


    public String intToString(int number, int groupSize) {
        StringBuilder result = new StringBuilder();

        for(int i = 3; i >= 0 ; i--) {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");

            if (i % groupSize == 0)
                result.append(" ");
        }
        result.replace(result.length() - 1, result.length(), "");

        return result.toString();
    }

    public ArrayList<String> getListGF() {
        return listGF;
    }

    public ArrayList<Integer> getIntList() {
        return intList;
    }

    public ArrayList<String> getBitList() {
        return bitList;
    }

    public ArrayList<String> getHexList() {
        return hexList;
    }

    public ArrayList<Integer> getMappingList() {
        return mappingList;
    }

    public String[][] getsBox() {
        return sBox;
    }
}
