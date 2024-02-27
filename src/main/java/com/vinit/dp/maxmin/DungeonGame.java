package com.vinit.dp.maxmin;

import java.util.Arrays;

public class DungeonGame {

    static final int inf = Integer.MAX_VALUE;
    static int[][] dp;
    static int row, col;
    public int calculateMinimumHP(int[][] dungeon) {
        row = dungeon.length;
        col = dungeon[0].length;
        dp = new int[row][col];
        int inf = Integer.MAX_VALUE;
        for (int[] arr : dp) Arrays.fill(arr, inf);
        dp[row - 1][col - 1] = Math.max(1, 1 + (-dungeon[row - 1][col - 1]));
        int currHealth, rightHealth, downHealth, nextHealth, minHealth;
        for (int i = row - 1; i >= 0; --i) {
            for (int j = col - 1; j >= 0; --j) {
                currHealth = dungeon[i][j];
                System.out.println(currHealth);
                rightHealth = getMinHealth(currHealth, i, j + 1, row, col);
                downHealth = getMinHealth(currHealth, i + 1, j, row, col);
                nextHealth = Math.min(rightHealth, downHealth);
                if (nextHealth != inf) minHealth = nextHealth;
                else minHealth = currHealth >= 0 ? 1 : 1 - currHealth;
                dp[i][j] = minHealth;
            }

        }
        return dp[0][0];
    }

    private static int getMinHealth(int curr, int i, int j, int row, int col) {
        if (i >= row || j >= col) return Integer.MAX_VALUE;
        int nextCell = dp[i][j];
        return Math.max(1, nextCell - curr);
    }
    public static void main(String[] args) {
        int[][] g = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println();
    }
}
