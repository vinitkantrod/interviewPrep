package com.vinit.dsalgo.subset;

import java.util.*;

public class LetterCombinations {

    public static void letterCombinations(String number) {
        List<String> res = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("2","abc");map.put("3","def");map.put("4","ghi");map.put("5","jkl");
        map.put("6","mnop");map.put("7","qrst");map.put("8","uvw");map.put("9","xyz");
        Deque<String> stringDeque = new ArrayDeque<>();
        stringDeque.add("");
        for (int i =0; i < number.length(); i++) {
            String digit = number.substring(i, i + 1);
            String fromMap = map.get(digit);
            int n = stringDeque.size();
            for (int j = 0; j < n; j++) {
                String el = stringDeque.pollFirst();
                for (int k = 0; k < fromMap.length(); k++) {
                    stringDeque.add(el.concat(fromMap.charAt(k)+""));
                }
            }
        }
        while (!stringDeque.isEmpty()) {
            res.add(stringDeque.poll());
        }
        System.out.println(Collections.singletonList(res));
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
