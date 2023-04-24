package com.vinit.dsalgo.leetcode75.level1.hash_map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows299 {

    public static String getHint(String secret, String guess) {
//        int bull = 0;
//        int cow = 0;
//        Map<Character, Integer> secretMap = new HashMap<>();
//        for (char c : secret.toCharArray())
//            secretMap.put(c, secretMap.containsKey(c) ?
//                    secretMap.get(c) + 1 : 1);
//        System.out.println(secretMap);
//        Set<Integer> bullIdx = new HashSet<>();
//        for (int i = 0; i < secret.length(); i++) {
//            char c1 = secret.charAt(i);
//            char c2 = guess.charAt(i);
//            if (c1 == c2) {
//                bull++;
//                secretMap.put(c1, secretMap.get(c1) - 1);
//                if (secretMap.get(c1) == 0) secretMap.remove(c1);
//                bullIdx.add(i);
//            }
//        }
//        System.out.println(secretMap);
//        System.out.println(bullIdx);
//        for (int i = 0; i < secret.length(); i++) {
//            if (!bullIdx.contains(i)) {
//                char c1 = secret.charAt(i);
//                char c2 = guess.charAt(i);
//                if (c1 != c2 && secretMap.containsKey(c2)) {
//                    if (secretMap.get(c2) <= 1) {
//                        secretMap.remove(c2);
//                    } else {
//                        secretMap.put(c2, secretMap.get(c2) - 1);
//                    }
//                    cow++;
//                }
//            }
//        }
//        return bull + "A" + cow + "B";

        StringBuilder first = new StringBuilder(secret);
        StringBuilder second = new StringBuilder(guess);
        HashMap<Character, Integer> dict = new HashMap<>();
        int numA = 0;
        int numB = 0;
        for (int i = secret.length() - 1; i > -1; i--)
        {
            if (first.charAt(i) == second.charAt(i)) {
                numA++;
                first.deleteCharAt(i);
                second.deleteCharAt(i);
            }
            else {
                if (!dict.containsKey(secret.charAt(i)))
                    dict.put(secret.charAt(i), 0);
                dict.put(secret.charAt(i), dict.get(secret.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < second.length(); i++)
        {
            if(dict.containsKey(second.charAt(i)) && dict.get(second.charAt(i)) > 0)
            {
                numB++;
                dict.put(second.charAt(i), dict.get(second.charAt(i)) - 1);
            }
        }
        return numA + "A" + numB + "B";
    }
    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("3123", "0114"));
        System.out.println(getHint("1122", "1222"));
    }
}
