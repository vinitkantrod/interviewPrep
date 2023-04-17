package com.vinit.dsalgo.strings.algoexpert;

public class CeaserCipherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        key = key % 26;
        StringBuilder newString = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int newAscii = (int)c + key;
            if (newAscii > 122) {
                newAscii = (newAscii % 123) + 97;
            }
            char newChar = (char) newAscii;
            newString.append(newChar);
            System.out.println(c + " - " + newChar);
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(caesarCypherEncryptor(s, 52));
    }

}
