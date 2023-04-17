package com.vinit.dsalgo.strings.algoexpert;

import java.util.*;
import java.util.stream.Collectors;

public class CommonCharacters {
    public static String[] commonCharacters(String[] strings) {
        // Write your code here.
        Set<Character> commonCharMap = new HashSet<>();
        Set<Character> newCommonCharMap = new HashSet<>();
        List<String> stringList = new ArrayList<>();
        for (char ch : strings[0].toCharArray()) {
            if (!commonCharMap.contains(ch)) commonCharMap.add(ch);
        }
        if (strings.length == 1) {
            String[] res = new String[commonCharMap.size()];
            for (char m : commonCharMap) {
                stringList.add(String.valueOf(m));
            }
            return stringList.toArray(res);
        }
        for (int i = 1; i < strings.length; i++) {
            Set<Character> characterSet = new HashSet<>();
            characterSet = strings[i].chars()
                    .mapToObj(e ->(char)e)
                    .collect(Collectors.toSet());
            for (char m: commonCharMap) {
                if (characterSet.contains(m)) {
                    newCommonCharMap.add(m);
                }
            }
            System.out.println("string: " + strings[i]);
            System.out.println(newCommonCharMap);
            commonCharMap = newCommonCharMap;
            newCommonCharMap = new HashSet<>();
        }
        if (commonCharMap.size() == 0) {
            return new String[] {};
        }
        String[] res = new String[commonCharMap.size()];
        for (char m : commonCharMap) {
            stringList.add(String.valueOf(m));
        }
        return stringList.toArray(res);
    }

    public static void main(String[] args) {
//        String[] s = {"abc", "bcd", "cbaccd"};
        String[] ss = {"ab&cdef!", "f!ed&cba", "a&bce!d", "ae&fb!cd", "efa&!dbc", "eff!&fff&fffffffbcda", "eeee!efff&fffbbbbbaaaaaccccdddd", "*******!***&****abdcef************", "*******!***&****a***********f*", "*******!***&****b***********c*"};
        System.out.println(Arrays.toString(commonCharacters(ss)));
    }
}
