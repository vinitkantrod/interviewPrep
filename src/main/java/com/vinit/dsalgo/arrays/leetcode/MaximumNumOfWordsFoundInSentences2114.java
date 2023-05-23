package com.vinit.dsalgo.arrays.leetcode;

public class MaximumNumOfWordsFoundInSentences2114 {

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String s : sentences) {
            int sCount = s.split(" ").length;
            if (sCount > max) max = sCount;
        }
        return max;
    }
}
