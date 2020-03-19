package com.xp.solutions._45_Jump_Game_II;

/**
 * 45. 跳跃游戏 II 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4] 输出: 2 解释: 跳到最后一个位置的最小跳跃数是 2。 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * @author yukong
 * @date 2020/3/19 09:45
 */
public class Solution {
    public int jump(int[] nums) {
        int jumpCount = 0;
        int farthest = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jumpCount++;
                end = farthest;
            }
        }
        return jumpCount;
    }
}
