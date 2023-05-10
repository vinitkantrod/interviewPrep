package com.vinit.dsalgo.mathematics.leetcode;

public class ReverseNumber7 {

    public int reverse(int x) {
        int rev = 0  ;
        while(x != 0){
            int rem = x % 10 ;
            x /= 10 ;
            // MAX_INT % 10 == 7
            if(rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE/10 && rem > 7){
                return 0 ;
            }
            // MIN_INT % 10 == -8
            if(rev < Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE/10 && rem < -8){
                return 0 ;
            }
            rev = rev*10 + rem ;
        }
        return rev ;
    }
}
