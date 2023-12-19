package com.vinit.dsalgo.arrays.leetcode;

import java.util.List;
import java.util.stream.IntStream;

public class FindWordsContainingCharacter2942 {

    public List<Integer> findWordsContaining(String[] words, char x) {
        return IntStream
                .range(0, words.length)
                .filter(index -> words[index].indexOf(x) >= 0)
                .boxed()
                .toList();
    }
    public static void main(String[] args) {

    }
}
