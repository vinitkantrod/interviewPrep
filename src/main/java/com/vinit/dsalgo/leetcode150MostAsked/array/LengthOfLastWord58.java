package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;
import java.util.List;

public class LengthOfLastWord58 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        List<String> lst = Arrays.asList(s.split(" "));
        System.out.println(Arrays.asList(lst));
        return lst.get(lst.size() - 1).length();
    }
}
