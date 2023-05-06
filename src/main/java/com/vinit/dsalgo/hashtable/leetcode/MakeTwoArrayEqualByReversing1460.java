package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MakeTwoArrayEqualByReversing1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
//        Set<Integer> set = new HashSet<>();
//        for (int i : target) set.add(i);
//        for (int i : arr) if (!set.contains(i)) return false;
//        return true;

        // LC code

        //Since we are given that we can reverse any time that subarray so we can directly say that if all elements are present then we can direcly say that we can achieve the target array

        //so to check all elements are present either you can use size of array elemetns(1000 here) as an array and use ++ for target and -- for arr then if any occurences>0 will give that cant achieve

        //or one can use HashSet to store all elements and put all target is present in arr elements then remove . finally check if any elements in hash then return false;

        //but risk in hashSet due to muliple times of same element so i am taking array soln
        //for ex- it fails in  target= 1,1,2,2,2 and arr=1,1,1,2,2

        int count[]=new int[1000+1];

        for(int i=0;i<target.length;i++)
        {
            count[target[i]]++;
        }

        for(int i=0;i<arr.length;i++)
        {
            count[arr[i]]--;
        }

        for(int i=0;i<=1000;i++)
        {
            if(count[i]>0)
                return false;
        }
        return true;
    }
}
