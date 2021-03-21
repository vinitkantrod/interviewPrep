package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;

public class WaterfallStream {

    public static double[] waterfallStreams(double[][] array, int source) {
        double[] rowAbove = array[0];
        rowAbove[source] = -1;

        for (int i = 1; i < array.length; i++) {
            double[] currentRow = array[i];

            for (int idx = 0; idx < rowAbove.length; idx++) {
                double valueAbove = rowAbove[idx];
                Boolean hasWaterAbove = valueAbove < 0;
                Boolean hasBlock = currentRow[idx] == 1;

                if (!hasWaterAbove) continue;
                if (!hasBlock) {
                    currentRow[idx] += valueAbove;
                    continue;
                }

                double splitWater = valueAbove / 2;

                int rightIdx = idx;
                while (rightIdx + 1 < currentRow.length) {
                    rightIdx++;
                    if (rowAbove[rightIdx] == 1) {
                        break;
                    }
                    if (currentRow[rightIdx] != 1 ) {
                        currentRow[rightIdx] += splitWater;
                        break;
                    }
                }

                int leftIdx = idx;
                while (leftIdx - 1 >= 0) {
                    leftIdx--;
                    if (rowAbove[leftIdx] == 1) {
                        break;
                    }
                    if (currentRow[leftIdx] != 1 ) {
                        currentRow[leftIdx] += splitWater;
                        break;
                    }
                }

             }
            rowAbove = currentRow;
            System.out.println(i + " - " + Arrays.toString(rowAbove));
        }

        for (int i = 0; i < rowAbove.length; i++) {
            rowAbove[i] = rowAbove[i] < 0 ? rowAbove[i] * -100 : rowAbove[i];
        }
        return rowAbove;
    }

    public static void main(String args[]) {
        double[][] array = {
                {0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0},
                {0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0},
                {1,1,1,0,0,1,0},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0}
        };
        System.out.println(Arrays.toString(waterfallStreams(array, 3)));
    }
}
