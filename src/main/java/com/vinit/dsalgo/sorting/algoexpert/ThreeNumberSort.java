package com.vinit.dsalgo.sorting.algoexpert;

import java.util.Arrays;

public class ThreeNumberSort {

    public static int[] threeNumberSort(int[] array, int[] order) {
        int[] valueIndex = {0,0,0};
        int first = 0;
        int second = 0;
        int third = array.length - 1;
        while (second <= third) {
            int element = array[second];
            int elemOrder = getElementOrder(order, element);
            System.out.println(element + " : " + elemOrder);
            if (elemOrder == 1) {
                second++;
            }
            else if (elemOrder == 0) {
                swap(array, first, second);
                first++;
                second++;
            } else {
                swap(array, second, third);
                third--;
            }
        }

        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static int getElementOrder(int[] order, int element) {
        for (int i = 0; i < order.length; i++) {
            if (element == order[i]) return i;
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {1,0,0,-1,-1,0,1,1};
        int[] order = {0,1,-1};
        System.out.println(Arrays.toString(threeNumberSort(arr, order)));
    }
}
