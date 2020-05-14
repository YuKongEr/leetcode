package com.xp.solutions._136_Single_Number;

/**
 * @author yukong
 * @date 2020/5/14 17:01
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
