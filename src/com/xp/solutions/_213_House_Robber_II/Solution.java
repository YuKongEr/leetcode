package com.xp.solutions._213_House_Robber_II;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/7 21:49
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(
                // 情况一 偷头不偷尾
                dp1(nums, 0, nums.length - 2),
                // 情况一 偷尾不偷头
                dp1(nums, 1, nums.length - 1));
    }

    private int dp1(int[] nums, int start, int end) {
        int[] dp = new int[end + 3];
        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[start];
    }
}
