package com.xp.solutions._312_Burst_Balloons;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * 312. 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * 说明:
 * <p>
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 * <p>
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * @author yukong
 * @date 2020/7/19 14:43
 */
public class Solution {
    int ans = 0;

    /**
     * 回溯算法 超时
     *
     * @param nums
     * @return
     */
    public int backMaxCoins(int[] nums) {
        LinkedList<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));
        backtracking(list, 0);
        return ans;
    }

    private void backtracking(LinkedList<Integer> list, int coins) {
        if (list.isEmpty()) {
            ans = Math.max(ans, coins);
        }
        for (int i = 0; i < list.size(); i++) {
            int target = list.get(i);
            int left = 1;
            if (i - 1 >= 0) {
                left = list.get(i - 1);
            }
            int right = 1;
            if (i + 1 < list.size()) {
                right = list.get(i + 1);
            }
            list.remove(i);
            backtracking(list, coins + left * target * right);
            list.add(i, target);

        }
    }

    private int[][] mem;


    public int maxCoins(int[] nums) {
        int n = nums.length;
        mem = new int[n + 1][n + 1];
        int[] newNums = new int[n + 2];
        System.arraycopy(nums, 0, newNums, 1, n);
        newNums[0] = 1;
        newNums[n + 1] = 1;
        return coinsDp(newNums, n);
    }


    /**
     * dp[i][j] 表示从i-j的最大引爆值
     * dp[i][j] = dp[i][k−1]+dp[k+1][j]+nums[i−1]*nums[k]*nums[j+1]i <= k <= j
     *
     * @param nums
     * @return
     */
    private int helper(int[] nums, int i, int j) {
        // 边界条件
        if (i > j) {
            return 0;
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        for (int k = i; k <= j; k++) {
            int left = helper(nums, i, k - 1);
            int right = helper(nums, k + 1, j);
            int delta = nums[k] * nums[i - 1] * nums[j + 1];
            mem[i][j] = Math.max(mem[i][j], left + right + delta);
        }
        return mem[i][j];
    }

    /**
     * 自底向上 动态规划
     * @param nums
     * @param n
     * @return
     */
    private int coinsDp(int[] nums, int n) {
        int[][] dp = new int[n + 2][n + 2];
        // 遍历长度
        for (int len = 1; len <= n; len++) {
            //选择七点
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                // 遍历每一个k
                for (int k = i; k <= j; k++) {
                    int res = dp[i][k - 1] + dp[k + 1][j] + nums[k] * nums[i - 1] * nums[j + 1];
                    if (dp[i][j] < res) {
                        dp[i][j] = res;
                    }
                }
            }
        }
        return dp[1][n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{3, 1, 5, 8}));
    }
}
