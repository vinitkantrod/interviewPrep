package com.vinit.dsalgo.algoexpert.strings;

import java.util.HashMap;
import java.util.Map;

public class CeaserCipherEncryption {

    public static String caesarCypherEncryptor(String str, int key) {
        char[] charArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int k = key % 26;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) map.put(charArray[i], i);
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(charArray[(map.get(c) + k) % 26]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 2));
    }
}
