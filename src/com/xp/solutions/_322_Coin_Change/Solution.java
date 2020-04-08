package com.xp.solutions._322_Coin_Change;

import java.util.Arrays;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/8 18:57
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        int max = coins[coins.length - 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i < coins[j]) {
                   break;
                }
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? - 1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[] {2}, 3));;
    }
}
