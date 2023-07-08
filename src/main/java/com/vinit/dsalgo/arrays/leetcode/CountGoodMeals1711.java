package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals1711 {

    public static int countPairs(int[] deliciousness) {
        int mod = (int)1e9+7;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int val : deliciousness){
            int power = 1;
            for(int j = 0; j <= 21; j++){
                if(power - val >= 0 && map.containsKey(power-val) == true){
                    count += map.get(power - val);
                    count = count % mod;
                }
                power *= 2;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return count;
    }
    private static Boolean isPowerOf2(int x) {
        while (x != 0) {
            System.out.println("x: " + x);
            if (x == 2) return true;
            if (x % 2 == 1) return false;
            x = x / 2;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] d = {1,3,5,7,9};
        System.out.println(countPairs(d));
    }
}
