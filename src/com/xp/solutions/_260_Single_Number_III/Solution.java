package com.xp.solutions._260_Single_Number_III;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/19 20:24
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
