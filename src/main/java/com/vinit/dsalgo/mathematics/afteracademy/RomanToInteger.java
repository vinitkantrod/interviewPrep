package com.vinit.dsalgo.mathematics.afteracademy;

import java.util.HashMap;
import java.util.Map;

/**
 * SYMBOL       VALUE
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<Character, Integer> romanTable = new HashMap<>();
        romanTable.put('I', 1);
        romanTable.put('V', 5);
        romanTable.put('X', 10);
        romanTable.put('L', 50);
        romanTable.put('C', 100);
        romanTable.put('D', 500);
        romanTable.put('M', 1000);
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0)
                number += romanTable.get(s.charAt(i));
            else {
                if (romanTable.get(s.charAt(i - 1)) < romanTable.get(s.charAt(i))) {
                    number = number - romanTable.get(s.charAt(i - 1));
                    number += (romanTable.get(s.charAt(i)) - romanTable.get(s.charAt(i - 1)));
                } else {
                    number += romanTable.get(s.charAt(i));
                }
            }
        }
        return number;
    }

    public static void main(String args[]) {
        System.out.println(romanToInt("XLII"));
    }
}
