package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;
import java.util.List;

public class NumberOfSegmentsInString434 {

    public int countSegments(String s) {
        if (s == "") return 0;
        return Arrays.asList(s.trim().split(" ")).size();
    }
}
