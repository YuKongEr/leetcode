package com.xp.solutions._343_Integer_Break;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * @author yukong
 * @date 2020/7/30 14:34
 */
public class Solution {

    /**
     * dp[i] = max(j * (i - j), j * dp[i - j])
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        // int[] dp = new int[n + 1];
        // dp[1] = 1;
        // dp[2] = 1;
        // for (int i = 3; i <= n; i++) {
        //     int max = 0;
        //     for (int j = 1; j < i; j++) {
        //         max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
        //     }
        //      dp[i] = max;
        // }
        // return  dp[n];

        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];

    }
}
