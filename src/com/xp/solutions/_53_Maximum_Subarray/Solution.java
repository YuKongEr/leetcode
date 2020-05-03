package com.xp.solutions._53_Maximum_Subarray;

/**
 * @author yukongcode@gmail.com
 * @date 2020/5/3 20:20
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
