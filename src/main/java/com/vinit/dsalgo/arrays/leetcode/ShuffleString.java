/**
 * Link: https://leetcode.com/problems/shuffle-string/
 */
package com.vinit.dsalgo.arrays.leetcode;

public class ShuffleString {

    public static String restoreString(String s, int[] indices) {
        char[] chars = new char[indices.length];
        StringBuilder newString = new StringBuilder();
        int j = 0;
        for (int i : indices) {
            chars[i] = s.charAt(j);
            j++;
        }
        for (char ch : chars) {
            newString.append(ch);
        }
        return newString.toString();
    }
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        System.out.println(restoreString(s, indices));
    }
}

//classic assure plus
//issue date: 3rd march 2016
//primum: 50000 annually
//current fund value: 174512
//policy no: 14235359
//Ajay Agarwal: 9319175694
