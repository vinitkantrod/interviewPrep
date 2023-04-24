package com.vinit.dsalgo.stack.leetcode;

import java.util.Collections;
import java.util.Stack;

public class DecodeString394 {

    public static String decodeString(String s) {
        Stack stack = new Stack();
        int digitStartRange = 48;
        int digitEndRange = 57;
        for (int i = 0; i < s.length(); i++) {
            // if character is encountered
            // if digits is encountered
            // if opening bracket is encountered
            // Push to stack
            if (s.charAt(i) != ']') {
                System.out.println(s.charAt(i));
                stack.push(s.charAt(i));
            } else {
                StringBuilder charSb = new StringBuilder();
                StringBuilder digitSb = new StringBuilder();
                // if closing bracket is encountered
                Boolean stopScanningChar = false;
                Boolean stopScanningDigit = false;
                while (!stopScanningChar) {
                    char c = (char)stack.pop();
                    System.out.println("stopScanningChar: false, char: " + c);
                    if ( c != '[') charSb.insert(0, c);
                    else stopScanningChar = true;
                }
                System.out.println(charSb.toString());
                while (!stopScanningDigit) {
                    if (stack.empty()) break;
                    char c = (char)stack.pop();
                    System.out.println("stopScanningDigit: false, char: " + c + ", " + (int)c);
                    if ((int)c >= digitStartRange && (int)c <= digitEndRange )
                        digitSb.insert(0, c);
                    else {
                        stopScanningDigit = true;
                        stack.push(c);
                    }
                }
                System.out.println(digitSb.toString());
                String newString = String.join("", Collections.nCopies(
                        Integer.parseInt(digitSb.toString()),
                        charSb.toString()
                ));
                System.out.println("newString: " + newString);
                if (newString != "") {
                    for (char c : newString.toCharArray()) {
                        stack.push(c);
                    }
                }
                System.out.println(stack);
            }
        }
        System.out.println("final Stack: " + stack);
        if (stack.empty()) return "";
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
    }
}
