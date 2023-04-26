package com.vinit.dsalgo.arrays.leetcode;

public class MinimumTimeVisitingAllPoints1266 {

    public static int minTimeToVisitAllPoints(int[][] points) {
        int distance = 0;
        if (points.length == 1) return 0;
        int oldX = points[0][0];
        int oldY = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int newX = points[i][0];
            int newY = points[i][1];
            System.out.println("x: " + newX + ", y: " + newY);
            int xDiff = Math.abs(newX - oldX);
            int yDiff = Math.abs(newY - oldY);
            System.out.println("xDiff: " + xDiff + ", yDiff: " + yDiff);
            if (xDiff == yDiff) distance += xDiff;
            else if (xDiff < yDiff) {
                distance += xDiff;
                yDiff = yDiff - xDiff;
                distance += yDiff;
            } else {
                distance += yDiff;
                xDiff = xDiff - yDiff;
                distance += xDiff;
            }
            oldX = newX;
            oldY = newY;
            System.out.println("distance: " + distance);
        }
        return distance;
    }
    public static void main(String[] args) {
//        int[][] points = {{1,1}, {3,4}, {-1,0}};
        int[][] points = {{3,2}, {-2,2}};
        System.out.println(minTimeToVisitAllPoints(points));
    }
}
