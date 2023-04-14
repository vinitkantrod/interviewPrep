package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);romanMap.put('V', 5);romanMap.put('X', 10);romanMap.put('L', 50);
        romanMap.put('C', 100);romanMap.put('D', 500);romanMap.put('M', 1000);
        int sum = 0;
        int i = s.length() - 1;
        int j = i - 1;
        while (j >= 0) {
            if (romanMap.get(s.charAt(i)) <= romanMap.get(s.charAt(j))){
                sum += romanMap.get(s.charAt(i));
                i--;
                j--;
            } else {
                sum += romanMap.get(s.charAt(i)) - romanMap.get(s.charAt(j));
                j--;
                i = j;
                j--;
            }
        }
        while (i >= 0) {
            sum += romanMap.get(s.charAt(i));
            i--;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
