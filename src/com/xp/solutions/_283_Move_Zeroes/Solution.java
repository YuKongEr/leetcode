package com.xp.solutions._283_Move_Zeroes;

/**
 * 283. 移动零 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
 *
 * @author yukong
 * @date 2020/3/19 22:16
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
