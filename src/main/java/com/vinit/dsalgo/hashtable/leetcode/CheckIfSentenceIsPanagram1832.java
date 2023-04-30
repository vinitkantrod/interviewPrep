package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckIfSentenceIsPanagram1832 {

    public boolean checkIfPangram(String sentence) {
        Set<Character> charSet = new HashSet<>();
        for (char c : sentence.toCharArray()) charSet.add(c);
        return charSet.size() == 26;
    }
}
