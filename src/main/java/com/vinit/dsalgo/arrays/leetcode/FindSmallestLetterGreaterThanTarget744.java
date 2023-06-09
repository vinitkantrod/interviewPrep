package com.vinit.dsalgo.arrays.leetcode;

public class FindSmallestLetterGreaterThanTarget744 {

    public static char nextGreatestLetter(char[] letters, char target) {
        char ch = 150;
        for (char c : letters) {
            System.out.println((int) c);
            if ((int) c > (int) target && (int) c < ch) {
                ch = c;
            }
        }
        return ch == 150 ? letters[0] : ch;
    }
    public static void main(String[] args) {
        char[] l = {'c','f','j'};
        System.out.println(nextGreatestLetter(l, 'g'));
    }
}
