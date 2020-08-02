package com.xp.solutions._122_Best_Time_to_Buy_and_Sell_Stock_II;

/**
 * @author yukong
 * @date 2020/8/2 10:34
 */
public class Solution {
    // 贪心算法  只要当天的价格比前一天高就可以买
    // public int maxProfit(int[] prices) {
    //     int profit = 0;
    //     for (int i = 1; i < prices.length; i++) {
    //         if (prices[i] > prices[i - 1]) {
    //             profit += prices[i] - prices[i - 1];
    //         }
    //     }
    //     return profit;
    // }

    /**
     * 动态规划
     * dp[i][j]: 表示第i天中 j 状态下的最大收益   j： 0 无股票 1 持有股票
     * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + p[i])
     * dp[i][1] = max(dp[i - 1][1] - p[i], dp[i - 1][1])
     **/
    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n < 2) {
            return 0;
        }


        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }
}
