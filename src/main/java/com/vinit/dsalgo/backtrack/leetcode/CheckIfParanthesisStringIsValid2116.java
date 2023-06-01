package com.vinit.dsalgo.backtrack.leetcode;

public class CheckIfParanthesisStringIsValid2116 {

    public static boolean canBeValid(String s, String locked) {
//        if (s.length() % 2 == 1) return false;
//        return combination(s, locked, s.substring(0, s.length()), 0);

        // LC code
        if(s.length()%2!=0)
            return false;
        int open=0,close =0,flip_allowed=0;
        for(int i =0;i<s.length();i++){
            if(locked.charAt(i)=='0')
                flip_allowed++;
            else{
                if(s.charAt(i)=='(')
                    open++;
                else
                    close++;
            }
            if(open+flip_allowed<close)
                return false;
        }
        open =0;close=0;
        flip_allowed=0;
        for(int i =s.length()-1;i>=0;i--){
            if(locked.charAt(i)=='0')
                flip_allowed++;
            else{
                if(s.charAt(i)=='(')
                    open++;
                else
                    close++;
            }
            if(flip_allowed+close<open)
                return false;
        }
        return true;
    }

    public static Boolean combination(String s, String locked, String updatedStr, int index) {
        if (index > s.length()) return false;
        System.out.println(index + " initial: " + updatedStr);
        if (index == s.length()) {
            if (isValid(updatedStr)) {
                return true;
            }
            return false;
        }
        if (isValid(updatedStr)) {
            return true;
        }
        if (locked.charAt(index) == '0') {
            String newUpdate = "";
            if (s.charAt(index) == '(') newUpdate = ")";
            else newUpdate = "(";
            String oldString = updatedStr;
            updatedStr = updatedStr.substring(0, index) + newUpdate + updatedStr.substring(index + 1, updatedStr.length());
            System.out.println(index + " new " + updatedStr);
            if (isValid(updatedStr)) {
                return true;
            }
            return combination(s, locked, oldString, index + 1) ||
                    combination(s, locked, updatedStr, index + 1);
        } else {
            return combination(s, locked, updatedStr, index + 1);
        }
    }
    public static Boolean isValid(String s) {
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else left--;
            if (left < 0) return false;
        }
        return left == 0;
    }

    public static void main(String[] args) {
        System.out.println(canBeValid("))()))", "010100"));
    }
}
