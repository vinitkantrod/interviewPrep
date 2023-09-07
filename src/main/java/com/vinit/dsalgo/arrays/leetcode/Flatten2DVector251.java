package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Flatten2DVector251 {

    class Vector2D {

        List<Integer> result = new ArrayList<>();
        int z = 0;
        public Vector2D(int[][] vec) {
            for (int i = 0; i < vec.length; i++) {
                for (int j = 0; j < vec[i].length; j++) {
                    result.add(vec[i][j]);
                }
            }
        }

        public int next() {
            return result.get(z++);
        }

        public boolean hasNext() {
            return z < result.size();
        }
    }

    public static void main(String[] args) {

    }
}
