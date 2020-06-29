package com.xp.solutions._457_Circular_Array_Loop;

/**
 * 457. 环形数组循环 给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，如果是负数 (-k)，则向后移动 k
 * 个索引。因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 * <p>
 * 确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,-1,1,2,2] 输出：true 解释：存在循环，按索引 0 -> 2 -> 3 -> 0 。循环长度为 3 。 示例 2：
 * <p>
 * 输入：[-1,2] 输出：false 解释：按索引 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。 示例 3:
 * <p>
 * 输入：[-2,1,-1,-2,-2] 输出：false 解释：按索引 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为按索引 1 -> 2 的运动是向前的运动，而按索引 2 -> 1
 * 的运动是向后的运动。一个循环中的所有运动都必须沿着同一方向进行。
 *
 * @author yukong
 * @date 2020/6/29 21:26
 */
public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        // 遍历每个节点 利用快排指针判断是否 有环
        // 退出条件
        // 1、 路径删除存在不同符号数字 题目要求环的前进方向只能有一个 所以遇到异符号的数字直接退出
        //     并且标记当前环的路径为inaccessible 题目标识0不会存在数组中 所以我们可以把inaccessible环上的每个节点置为0 以后遇到0 直接退出判断下一个
        // 2、如果nextIndex = currentIndex 直接退出 因为题目要求环的长度>1
        // 3、如果当前节点的值为0 直接退出 因为标识为0的节点 已经表明它不可能出现在环上
        if (nums == null || nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = i;
            // 如果不为0 判断当前节点会不会出现在环上
            while (true) {
                //slow 走一步
                int preSlow = slow;
                slow = next(nums, slow);
                if (slow == preSlow || nums[slow] * nums[preSlow] <= 0) {
                    setZero(nums, i);
                    break;
                }
                // fast 走两步
                int preFast = fast;
                fast = next(nums, fast);

                if (fast == preFast || nums[fast] * nums[preFast] <= 0) {
                    setZero(nums, i);
                    break;
                }
                preFast = fast;
                fast = next(nums, fast);
                if (fast == preFast || nums[fast] * nums[preFast] <= 0) {
                    setZero(nums, i);
                    break;
                }
                if (fast == slow) {
                    return true;
                }

            }
        }
        return false;
    }

    //计算下一个位置时，避免越界
    private int next(int[] nums, int i) {
        int next = i + nums[i];
        if (next >= 0) {
            return next % nums.length;
        } else {
            return nums.length + next % nums.length;
        }
    }

    private void setZero(int[] nums, int i) {
        int j;
        while (true) {
            j = next(nums, i);
            if (nums[j] == 0 || nums[i] * nums[j] < 0) {
                nums[i] = 0;
                break;
            }
            nums[i] = 0;
            i = j;
        }

    }
}
