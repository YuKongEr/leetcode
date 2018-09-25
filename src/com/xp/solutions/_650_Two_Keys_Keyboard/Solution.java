package com.xp.solutions._650_Two_Keys_Keyboard;

/**
 * @author: yukong
 * @date: 2018/7/2 09:42
 * @description:
 */
public class Solution {
    public int minSteps(int n) {
        int res = 0;
        int[] dp = new int[n];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}
