package com.vinit.dsalgo.sorting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mp = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            if(i==0 ||(i>0 && nums[i]!=nums[i-1]))
            {
                int low=i+1;
                int high=nums.length-1;
                int sum=0-nums[i];
                while(low<high)
                {
                    if(nums[low]+nums[high]==sum)
                    {
                        mp.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low<high && nums[low]==nums[low+1])
                        {
                            low++;
                        }
                        while(low<high && nums[high]==nums[high-1])
                        {
                            high--;
                        }
                        low++;
                        high--;
                    }
                    else if(nums[low]+nums[high]<sum)
                    {
                        low++;
                    }
                    else
                    {
                        high--;
                    }
                }
            }
        }
        return mp;
    }
    public static void main(String[] args) {
        int[] n = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(n));
    }
}
