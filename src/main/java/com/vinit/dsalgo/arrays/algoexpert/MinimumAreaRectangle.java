package com.vinit.dsalgo.arrays.algoexpert;

import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {

    public static int minimumAreaRectangle(int[][] points) {
        // Write your code here.
        Integer minArea = Integer.MAX_VALUE;
        Set<String> pointSets = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            pointSets.add(createPoint(points[i]));
        }

        for (int currentPoint = 0; currentPoint < points.length; currentPoint++) {
            int p2x = points[currentPoint][0];
            int p2y = points[currentPoint][1];
            for (int previousPoint = 0; previousPoint < currentPoint; previousPoint++) {
                int p1x = points[previousPoint][0];
                int p1y = points[previousPoint][1];

                Boolean pointShareValue = p1x == p2x || p1y == p2y;
                if (pointShareValue) continue;

                Boolean point1onOpposite = pointSets.contains(covertPointToString(p1x, p2y));
                Boolean point2onOpposite = pointSets.contains(covertPointToString(p2x, p1y));
                Boolean oppositeDiagonalExists = point1onOpposite && point2onOpposite;

                if (oppositeDiagonalExists) {
                    Integer localArea = Math.abs(p2x - p1x) * Math.abs(p2y - p1y);
                    if (minArea > localArea) minArea = localArea;
                }
            }
        }

        System.out.println(minArea);
        return minArea != Integer.MAX_VALUE ? minArea : 0;
    }

    public static String covertPointToString(int p1, int p2) {
        return p1 + ":" + p2;
    }

    public static String createPoint(int[] point) {
        return point[0] + ":" + point[1];
    }

    public static void main(String args[]) {
        int[][] points = { {1,5}, {5,1}, {4,2}, {2,4}, {2,2}, {1,2}, {4,5}, {2,5}, {-1,-2} };
        minimumAreaRectangle(points);
    }
}
