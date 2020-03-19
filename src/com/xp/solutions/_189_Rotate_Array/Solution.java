package com.xp.solutions._189_Rotate_Array;

/**
 * @author yukong
 * @date 2020/3/19 21:49
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0) {
            return;
        }
        k = k % nums.length;
        revert(nums, 0, nums.length - 1);

        revert(nums, 0, k - 1);
        revert(nums, k , nums.length - 1);
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    private void revert(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++ ,end--);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -100, 3, 99};
        new Solution().rotate(nums, 3);
    }
}
