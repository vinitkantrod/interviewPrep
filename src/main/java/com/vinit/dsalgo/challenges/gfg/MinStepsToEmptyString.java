package com.vinit.dsalgo.challenges.gfg;

public class MinStepsToEmptyString {

    public static int minSteps(String str) {
        int a = 0;
        int b = 0;
        if (str.charAt(0) == 'a') {
            a++;
        } else b++;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == 'a' && str.charAt(i) == 'b') {
                b++;
            }
            if (str.charAt(i - 1) == 'b' && str.charAt(i) == 'a') {
                a++;
            }
        }
        return Math.min(a, b) + 1;
    }

    public static void main(String[] args) {
        String str = "bbaaabb";
        minSteps(str);
    }
}
