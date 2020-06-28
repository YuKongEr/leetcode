package com.xp.solutions._209_Minimum_Size_Subarray_Sum;

/**
 * @author yukong
 * @date 2020/6/28 18:09
 */
public class Solution {

    // 滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sliderSum = 0;
        while (right < nums.length) {
            if (sliderSum < s) {
                sliderSum += nums[right++];
            }
            while (sliderSum >= s && left < nums.length) {
                minLen = Math.min(right - left, minLen);
                sliderSum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
