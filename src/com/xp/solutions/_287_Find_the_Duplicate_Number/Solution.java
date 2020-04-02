package com.xp.solutions._287_Find_the_Duplicate_Number;

/**
 * @author yukong
 * @date 2020/4/2 22:26
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 0)
            return -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
       // System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(new Solution().findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }
}
