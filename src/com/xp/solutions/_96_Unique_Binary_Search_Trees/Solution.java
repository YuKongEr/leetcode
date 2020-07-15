package com.xp.solutions._96_Unique_Binary_Search_Trees;

/**
 * @author yukong
 * @date 2020/7/15 21:37
 */
public class Solution {
    /**
     * dp
     * dp[i] = dp[j - 1] * dp[i - j] (j = 1..i)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
