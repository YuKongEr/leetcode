package com.xp.solutions._713_Subarray_Product_Less_Than_K;

/**
 * @author yukong
 * @date 2020/5/18 18:21
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if( k <= 1) {
            return 0;
        }
        int res = 0;
        int count = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            count *= nums[right];
            while (count >= k) {
                count /= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
