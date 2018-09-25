package com.xp.solutions._1_TWO_SUM;

/**
 * Description:
 * User: yukong
 * Date: 2018-01-15
 * Time: 14:09
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }
}
