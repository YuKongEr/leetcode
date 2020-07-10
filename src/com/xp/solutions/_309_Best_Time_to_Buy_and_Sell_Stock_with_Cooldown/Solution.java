package com.xp.solutions._309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

/**
 * @author yukong
 * @date 2020/7/10 18:05
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        // 不买
        dp[0][0] = 0;
        // 买
        dp[0][1] = -prices[0];
        // 冷冻
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            //  i- 1 不持有 或者 i - 1 是过渡期
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // i - 1 原本持有股票 i - 1没有持有股票 但是第i天买了
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //第i天是冷冻期只有一种情况，第i-1天持有股票且卖出
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        //最后最大利润为最后一天，不持有股票或者进入冷冻期的情况
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
