package com.vinit.dsalgo.arrays.leetcode;

interface ArrayReader {
    public default int get(int index) {
        return index;
    }
}
public class SearchInSortedArrayOfUnknownSize702 {

    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;

        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1; // multiplying by 2
        }

        int pivot, num;
        while (left <= right) {
            pivot = left + ((right - left) >> 1);
            num = reader.get(pivot);

            if (num == target) return pivot;
            if (num > target) right = pivot - 1;
            else left = pivot + 1;
        }

        return -1;
    }
}
