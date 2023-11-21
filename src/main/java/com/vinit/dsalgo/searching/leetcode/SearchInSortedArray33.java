package com.vinit.dsalgo.searching.leetcode;

import java.util.List;

public class SearchInSortedArray33 {

    public int search(List<Integer> nums, int target) {
        int low = 0, high = nums.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums.get(mid) == target) {
                return mid;
            }

            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) <= target && target < nums.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums.get(mid) < target && target <= nums.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(fun());;
    }

    static int fun() {
         int x = 0;
        return ++x;
    }
    static class Parent {
        void show() {
            System.out.println("parent");
        }
    }

    static class Child extends Parent {
        void show() {
            System.out.println("Child");
        }
    }

}

