package com.xp.solutions.practice;

/**
 * 面试题 08.03. 魔术索引
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 *
 * @author yukong
 * @date 2020/7/31 13:49
 */
public class MagicIndexLCCI {
    public int findMagicIndex(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        int res = helper(nums, lo, mid - 1);
        if (res != -1) {
            return res;
        } else if (nums[mid] == mid) {
            return mid;
        } else {
            return helper(nums, mid + 1, hi);
        }
    }

}
