package com.xp.solutions._279_Perfect_Squares;

import java.util.Arrays;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/8 14:04
 */
public class Solution {
    /**
     * dp[i] = dp[i - k*k] + 1
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int sqrtN = (int) Math.sqrt(n) + 1;
        int[] sqrtNs = new int[sqrtN];
        for (int i = 1; i < sqrtN; i++) {
            sqrtNs[i] = i * i;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // base case
        dp[1] = 1;
        dp[0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < sqrtN; j++) {
                // 如果当前数 小于 平方数列表就不用循环判断了
                if (i < sqrtNs[j]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - sqrtNs[j]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}
