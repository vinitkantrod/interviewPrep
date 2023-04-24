package com.vinit.dsalgo.stack.leetcode;

import java.util.Stack;

public class BaseballGames682 {

    public static int calPoints(String[] operations) {
        int sum=0;
        int[] arr = new int[operations.length];
        int count=0;

        for(int i=0;i<operations.length;i++){
            // System.out.println(count + " " + operations[i]);
            if(operations[i].equals("C")){
                arr[--count]=0;
            }
            else if(operations[i].equals("D")){
                arr[count] = 2 * arr[count-1];
                count++;
            }
            else if(operations[i].equals("+")){
                arr[count]= arr[count-1] + arr[count-2];
                count++;
            }
            else{
                // System.out.println(operations[i]);
                arr[count] = Integer.parseInt(operations[i]);
                count++;
            }
        }
        for(int j=0;j<arr.length;j++){
            //System.out.println(arr[j]);
            sum += arr[j];
        }
        return sum;
    }
    public static void main(String[] args) {
        String[] s = {"5", "2", "C", "D", "+"};
//        String[] s = {"5","-2","4","C","D","9","+","+"};
//        String[] s = {"1","C"};
        System.out.println(calPoints(s));
    }
}
