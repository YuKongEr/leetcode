package com.xp.solutions._898_Bitwise_ORs_of_Subarrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author yukong
 * @date 2019-03-16 18:25
 * 我们有一个非负整数数组 A。
 *
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 *
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 *
 *
 *
 * 示例 1：
 *
 * 输入：[0]
 * 输出：1
 * 解释：
 * 只有一个可能的结果 0 。
 * 示例 2：
 *
 * 输入：[1,1,2]
 * 输出：3
 * 解释：
 * 可能的子数组为 [1]，[1]，[2]，[1, 1]，[1, 2]，[1, 1, 2]。
 * 产生的结果为 1，1，2，1，3，3 。
 * 有三个唯一值，所以答案是 3 。
 * 示例 3：
 *
 * 输入：[1,2,4]
 * 输出：6
 * 解释：
 * 可能的结果是 1，2，3，4，6，以及 7 。
 */
public class Solution {

    /**
     * dp实现: dp[i][j] 表示下表从i到j中不按位或运算之后的值
     * 状态转移方程: dp[i][j] = dp[i][j-1] | A[j]
     * 时间复杂度 O(n^2)
     * @param A
     * @return
     */
    public int subarrayBitwiseORs(int[] A) {

        int n = A.length;
        int[][] dp = new int[n][n];
        HashSet<Integer> ans = new HashSet<>();
        // 每一个子串的长度 l
        for (int l = 1; l <= A.length; l++) {
            ans.add(A[l-1]);
            // i 起始下标 j结束下标
            for (int i = 0; i <= n -l; i++) {
                int j = i + l -1;
                // 如果长度为1
                if(l == 1){
                    dp[i][j] = A[i];
                    continue;
                }
                dp[i][j] = dp[i][j - 1] | A[j];
                ans.add(dp[i][j]);
            }
        }
        return ans.size();
    }
}
