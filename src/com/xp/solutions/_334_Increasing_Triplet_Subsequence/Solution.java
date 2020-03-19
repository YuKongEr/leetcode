package com.xp.solutions._334_Increasing_Triplet_Subsequence;

import java.util.Arrays;

/**
 * 334. 递增的三元子序列 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1， 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。 说明: 要求算法的时间复杂度为
 * O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5] 输出: true 示例 2:
 * <p>
 * 输入: [5,4,3,2,1] 输出: false
 *
 * @author yukong
 * @date 2020/3/19 23:09
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if(dp[i] >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
