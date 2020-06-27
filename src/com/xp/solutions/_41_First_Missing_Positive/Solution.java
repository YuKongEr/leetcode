package com.xp.solutions._41_First_Missing_Positive;

/**
 * 41. 缺失的第一个正数 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0] 输出: 3 示例 2:
 * <p>
 * 输入: [3,4,-1,1] 输出: 2 示例 3:
 * <p>
 * 输入: [7,8,9,11,12] 输出: 1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * @author yukong
 * @date 2020/6/27 15:12
 */
public class Solution {

    /**
     * 解题思路 我们使用一种 “座位交换法" 来达到 in-place 的目的：
     * <p>
     * 从第一个位置开始，让座位上的乘客走到自己应该坐的位置，并让该位置的人坐到第一个位置。一直进行这样的操作，直到第一个位置的人坐到自己位置。 不过有时候我们知道，有的人总喜欢逃票。因此终止条件就是，一旦发现第一个位置的人逃票（票号
     * <= 0，或 >= 最大座位号)，则终止交换。 对第二到N个位置做相同的操作。
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 交换位置
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
