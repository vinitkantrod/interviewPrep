package com.vinit.dsalgo.mathematics.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber202 {

    public static boolean isHappy(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        int temp=0;
        int rem=0;
        if(n==1) return true;
        while(true){
            temp=0;
            map.put(n,0);
            while(n>0){
                rem=n%10;
                temp+=(rem*rem);
                n/=10;
            }
            n=temp;
            if(map.containsKey(n)) return false;
            if(n==1) return true;
        }
    }

    public static void main(String[] args) {

    }
}
