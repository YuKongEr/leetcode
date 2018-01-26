package com.xp.solutions._16_3Sum_Closest;

import java.util.Arrays;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._16_3Sum_Closest
 * @Description: 3Sum Closest
 * @date 2018/1/26 16:38
 **/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closest  = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);
        for (int i = 0; i < nums.length - 2 ; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    closest = sum;
                }
                if ( sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closest;
    }
}
