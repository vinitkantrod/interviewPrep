package com.vinit.dsalgo.strings;

public class BuddyString859 {

    public static boolean buddyStrings(String s, String goal) {
        int count = 0;
        if (s.length() != goal.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                if (count % 2 == 0 && !s.equals(goal)) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(buddyStrings("ab","ba"));
    }
}
