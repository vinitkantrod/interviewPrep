package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String columnTitle) {
        int j = columnTitle.length();
        int result = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('A', 1);map.put('B', 2);map.put('C', 3);map.put('D', 4);map.put('E', 5);
//        map.put('F', 6);map.put('G', 7);map.put('H', 8);map.put('I', 9);map.put('J', 10);
//        map.put('K', 11);map.put('L', 12);map.put('M', 13);map.put('N', 14);map.put('O', 15);
//        map.put('P', 16);map.put('Q', 17);map.put('R', 18);map.put('S', 19);map.put('T', 20);
//        map.put('U', 21);map.put('V', 22);map.put('W', 23);map.put('X', 24);map.put('Y', 25);
//        map.put('Z', 26);
//        while (j > 0) {
//            result += map.get(columnTitle.charAt(j-1)) * Math.pow(26, (columnTitle.length() - j));
//            j--;
//        }

        int power = 0;
        for (int i = columnTitle.length() - 1; i >=0; i--) {
            result += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, power);
            power++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }
}
