package com.vinit.dsalgo.greedy.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassPhotos {

    public static boolean classPhotos(
            ArrayList<Integer> redShirtHeights,
            ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        int i = 0;
        int j = 0;
        if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
            while (i < redShirtHeights.size() && checkHeight(redShirtHeights, blueShirtHeights, i, j)) {
                i++;
                j++;
            }
            if (j == blueShirtHeights.size()) return true;
        } else if (blueShirtHeights.get(0) > redShirtHeights.get(0)) {
            while (i < redShirtHeights.size() && checkHeight(blueShirtHeights, redShirtHeights, i, j)) {
                i++;
                j++;
            }
            if (j == blueShirtHeights.size()) return true;
        }
        return false;
    }

    public static boolean checkHeight(ArrayList<Integer> redShirtHeights,
                                      ArrayList<Integer> blueShirtHeights, int a, int b) {
        return (redShirtHeights.get(a) > blueShirtHeights.get(b)) ? true : false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> arrays = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> sequence = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));
        System.out.println(classPhotos(arrays, sequence));
    }
}
