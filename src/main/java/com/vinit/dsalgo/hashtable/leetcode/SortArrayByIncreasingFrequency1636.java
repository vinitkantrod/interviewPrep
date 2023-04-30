package com.vinit.dsalgo.hashtable.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class SortArrayByIncreasingFrequency1636 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> tempList = new TreeMap<>();// to counting each number
        Map<Integer, ArrayList<Integer>> countList = new TreeMap<>();//Counting numbers in arrayList
        // Counting and adding
        for(int a: nums){
            if(tempList.containsKey(a)) tempList.put(a, tempList.get(a)+1);
            else tempList.put(a,1);
        }
        // numbers with the same numbers adding same array
        for(Map.Entry<Integer,Integer> entry: tempList.entrySet()){
            int val = entry.getValue(); int key = entry.getKey();
            if(!countList.containsKey(val)) countList.put(val, new ArrayList<Integer>());
            countList.get(val).add(key);
        }

        int index = 0;
        for(Map.Entry<Integer,ArrayList<Integer>> entry: countList.entrySet()){
            int val = entry.getKey(); ArrayList<Integer> array = entry.getValue();
            Collections.sort(array);// Sort each Array
            for(int a = array.size()-1; a>-1; a--){
                int value = array.get(a);
                for(int b = 0; b < val; b++){
                    nums[index] = value;
                    index++;
                }
            }
        }
        return nums;
    }

}
