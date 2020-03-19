package com.xp.solutions._152_Maximum_Product_Subarray;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4] 输出: 6 解释: 子数组 [2,3] 有最大乘积 6。 示例 2:
 * <p>
 * 输入: [-2,0,-1] 输出: 0 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author yukong
 * @date 2020/3/19 20:51
 */
public class Solution {
    /**
     * 解题方案 思路 标签：动态规划 遍历数组时计算当前最大值，不断更新 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
     * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i]) 当负数出现时则imax与imin进行交换再进行下一步计算
     * 时间复杂度：O(n)O(n)
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            int preMax = dpMax;
            dpMax = Math.max(Math.max(preMax * nums[i], nums[i]), dpMin * nums[i]);
            dpMin = Math.min(Math.min(preMax * nums[i], nums[i]), dpMin * nums[i]);
            max = Math.max(dpMax, max);
        }
        return max;
    }
}
