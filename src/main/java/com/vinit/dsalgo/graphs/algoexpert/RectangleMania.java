package com.vinit.dsalgo.graphs.algoexpert;

import java.util.HashSet;
import java.util.Set;

public class RectangleMania {

    public static int rectangleMania(Point[] coords) {
        Set<String> coordsTable = getCordsTable(coords);
        System.out.println("coordsTable: " + coordsTable);
        return getRectangleCount(coords, coordsTable);
    }

    public static int getRectangleCount(Point[] coords, Set<String> coordsTable) {
        int rectangleCount = 0;
        for (Point coord1 : coords) {
            for (Point coord2 : coords) {
                System.out.println("point1: " + coord1 + ", point2: " + coord2);
                if (!isTopRightPoint(coord1, coord2)) continue;
                String upperCoordString = getCoordToString(new Point(coord1.x, coord2.y));
                String rightCoordString = getCoordToString(new Point(coord2.x, coord1.y));
                System.out.println("upperCoordString: " + upperCoordString + ", rightCoordString: " + rightCoordString +
                        ", res: " + (coordsTable.contains(upperCoordString) && coordsTable.contains(rightCoordString)) );
                if (coordsTable.contains(upperCoordString) && coordsTable.contains(rightCoordString))
                    rectangleCount += 1;
            }
        }
        return rectangleCount;
    }

    public static Boolean isTopRightPoint(Point coord1, Point coord2) {
        return (coord2.x > coord1.x && coord2.y > coord1.y);
    }

    public static Set<String> getCordsTable(Point[] coords) {
        Set<String> coordsTable = new HashSet<>();
        for (Point point : coords) {
            coordsTable.add(getCoordToString(point));
        }
        return coordsTable;
    }

    public static String getCoordToString(Point point) {
        return Integer.toString(point.x) + "-" + Integer.toString(point.y);
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.x + "-" + this.y;
        }
    }
    public static void main(String args[]) {
        Point[] coords = {
                new Point(0,0),
                new Point(0,1),
                new Point(1,1),
                new Point(1,0),
                new Point(2,1),
                new Point(2,0),
                new Point(3,1),
                new Point(3,0),
        };
        System.out.println(rectangleMania(coords));
    }
}
