package com.xp.solutions._120_Triangle;

import java.util.List;

/**
 * @author yukong
 * @date 2020/7/14 21:05
 */
public class Solution {
    /**
     * dp 动态规划
     * dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]
     *
     * @param triangle
     * @return
     */
    public int dp(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                System.out.println(dp[j]);
            }
            System.out.println(dp[i]);
            System.out.println("-----");
        }
        return dp[0];
    }

    Integer[][] memo;

    /**
     * dfs + memo
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

}
