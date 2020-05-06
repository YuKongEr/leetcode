package com.xp.solutions._983_Minimum_Cost_For_Tickets;

/**
 * @author yukongcode@gmail.com
 * @date 2020/5/6 09:17
 */
public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int[] dp = new int[len + 1000];
        int max = days[len - 1];
        int min = days[0];
        int dayIndex = len - 1;
        for (int i = max; i >= min; i--) {
            if (i == days[dayIndex]) {
                dp[i] = Math.min(dp[i + 1] + costs[0], Math.min(dp[i + 7] + costs[1], dp[i + 30] + costs[2]));
                dayIndex--;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[min];
    }
}
