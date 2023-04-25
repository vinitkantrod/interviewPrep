package com.vinit.dsalgo.strings.leetcode;

public class RemovedColorPeices2038 {

    public static boolean winnerOfGame(String colors) {
        int aliceCount = 0;
        int bobCount = 0;
        if (colors.length() <= 2 ) return false;
        int i = 1;
        while (i < colors.length() - 1) {
            if (colors.charAt(i) == 'A') {
                if (colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
                    aliceCount++;
                }
            } else {
                if (colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
                    bobCount++;
                }
            }
            i++;
        }
        System.out.println("alice: " + aliceCount + " :: bob: " + bobCount);
        return aliceCount > bobCount ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(winnerOfGame("AAABABB"));
        System.out.println(winnerOfGame("AA"));
        System.out.println(winnerOfGame("ABBBBBBBAAA"));
        System.out.println(winnerOfGame("BBBAAAABB"));
    }
}
