package com.xp.solutions._198_House_Robber;

import java.util.Arrays;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/7 18:45
 */
public class Solution {

    private int[] mem;
    public int rob(int[] nums) {
        mem = new int[nums.length];
        Arrays.fill(mem, -1);
        return dp(nums, 0);
    }


    private int dp(int[] num, int start) {
        if(start >= num.length) {
            return 0;
        }
        if(mem[start] != -1) {
            return mem[start];
        }
        mem[start] = Math.max(
                // 不抢 去下一家
                dp(num, start + 1),
                // 抢 去下下家
                num[start] + dp(num, start + 2));
        return mem[start];
    }

    private int dp1(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 2];
        for (int i = end; i >= start ; i--) {
            dp[i] = Math.max(dp[i + 1],nums[i] + dp[i + 2]);
        }
        return dp[0];
    }



    public static void main(String[] args) {
        System.out.println(new Solution().dp1(new int[]{2,3,2}, 0, 2));
    }
}
