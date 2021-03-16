package com.vinit.dsalgo.strings.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static boolean generateDocument(String characters, String document) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (Character c : characters.toCharArray()) {
            if (characterCountMap.containsKey(c)) characterCountMap.put(c, characterCountMap.get(c) + 1);
            else characterCountMap.put(c, 1);
        }
        System.out.println(characterCountMap);
        for (Character c : document.toCharArray()) {
            System.out.println("new char: " + c);
            if (!characterCountMap.containsKey(c)) return false;
            int charCount = characterCountMap.get(c);
            if (charCount <= 0) return false;
            else characterCountMap.put(c, charCount - 1);
            System.out.println(characterCountMap);
        }
        return true;
    }
    public static void main(String args[]) {
        System.out.println(generateDocument("abcabc", "aabbccc"));
//        System.out.println(generateDocument("Bste!hetsi ogEAexpelrt x ", "AlgoExpert is the Best!"));
    }
}
