package com.vinit.dp.maxmin;

public class MaximumPathSum {

    public static int minPathSum(int[][] grid) {
        // Forward Approach
//        int[][] dp = new int[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; ++i) {
//            for (int j = 0; j < grid[0].length; ++j) {
//                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
//                else if (i == 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
//                else if (j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
//                else {
//                    int topSum = i == 0 ? 0 : dp[i - 1][j];
//                    int leftSum = j == 0 ? 0 : dp[i][j - 1];
//                    dp[i][j] = Math.min(topSum, leftSum) + grid[i][j];
//                }
//            }
//        }
//        return dp[grid.length - 1][grid[0].length - 1];

        // Backward approach
        for (int i = grid.length - 1; i >= 0; --i) {
            for (int j = grid[0].length - 1; j >= 0; --j) {
                if (i == grid.length - 1 && j != grid[0].length - 1)
                    grid[i][j] += grid[i][j + 1];
                else if (i != grid.length - 1 && j == grid[0].length - 1)
                    grid[i][j] += grid[i + 1][j];
                else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }
    public static void main(String[] args) {
        int[][] m = new int[][]{{1,3,1,},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(m));
    }
}
