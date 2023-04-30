package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage2325 {

    public static String decodeMessage(String key, String message) {
        Map<Character, Character> alphabetMap = new HashMap<>();
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int k = 0;
        for (int i = 0; i < key.length(); i++) {
            if (!alphabetMap.containsKey(key.charAt(i)) && (int) key.charAt(i) != 32) {
                alphabetMap.put(key.charAt(i), alphabets.charAt(k));
                k++;
            } else continue;
        }
//        System.out.println(alphabetMap);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if ((int)message.charAt(i) == 32) sb.append(message.charAt(i));
            else sb.append(alphabetMap.get(message.charAt(i)));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(decodeMessage(
                "the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv")
        );
    }
}
