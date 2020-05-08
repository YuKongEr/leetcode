package com.xp.solutions._221_Maximal_Square;

/**
 * @author yukongcode@gmail.com
 * @date 2020/5/8 21:46
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 1 || matrix[0].length == 1) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int max = 0;
        int[][] dp = new int[height + 1][width + 1];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <  width; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i][j])) + 1;
                    max = Math.max(dp[i + 1][j + 1], max);
                }
            }
        }
        return max * max;
    }
}
