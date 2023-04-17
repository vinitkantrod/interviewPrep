package com.vinit.dsalgo.strings.algoexpert;

import java.util.Arrays;

public class ReverseWordsInString {

    public static String reverseWordsInString(String string) {
        // Write your code here.
        char[] characters = string.toCharArray();
        characters = reverseCharListString(characters, 0, string.length() - 1);
        System.out.println(Arrays.toString(characters));
        int startWord = 0;
        while (startWord < characters.length) {
            int endWord = startWord;
            while (endWord <= characters.length - 1 && characters[endWord] != ' ') {
                endWord++;
            }
            characters = reverseCharListString(characters, startWord, endWord - 1);
            startWord = endWord + 1;
        }
        System.out.println(Arrays.toString(characters));
        return new String(characters);
    }

    public static char[] reverseCharListString(char[] characters, int i, int j) {
        while (i < j) {
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
            i++;
            j--;
        }
        return characters;
    }

    public static void main(String args[]) {
        reverseWordsInString("AlgoExpert is the   best!");
    }
}
