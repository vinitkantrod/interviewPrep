package com.vinit.dsalgo.arrays.leetcode;

public class MajorityElement169 {

    public static int majorityElement(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int el=0;

        // applying Moores voting Algorithm
        for(int i=0;i<n;i++){
            if(cnt==0){
                cnt =1;
                el=nums[i];
            }
            else if(el == nums[i]) cnt++;
            else cnt--;
            System.out.println(el + " - " + cnt);
        }

        // checking if the stored element is majority element
        int cnt1=0;
        for(int i=0;i<n;i++){
            if(nums[i]== el) cnt1++;
        }
        if(cnt1>(n/2)) return el;
        return -1;
    }

    public static void main(String[] args) {
        int[] n = {1,2,2,2,1};
        System.out.println(majorityElement(n));
    }
}
