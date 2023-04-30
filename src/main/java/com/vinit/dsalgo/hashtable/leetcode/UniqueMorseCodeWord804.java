package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWord804 {

    public int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> map = new HashMap<>();
        String al = "abcdefghijklmnopqrstuvwxyz";
        String[] t = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (int i = 0; i < al.length(); i++) {
            map.put(al.charAt(i), t[i]);
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : words[i].toCharArray()) {
                sb.append(map.get(c));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
