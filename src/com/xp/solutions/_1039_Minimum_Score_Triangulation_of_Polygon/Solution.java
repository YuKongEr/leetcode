package com.xp.solutions._1039_Minimum_Score_Triangulation_of_Polygon;

/**
 * 1039. 多边形三角剖分的最低得分 给定 N，想象一个凸 N 边多边形，其顶点按顺时针顺序依次标记为 A[0], A[i], ..., A[N-1]。
 * <p>
 * 假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 N-2 个三角形的值之和。
 * <p>
 * 返回多边形进行三角剖分后可以得到的最低分。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3] 输出：6 解释：多边形已经三角化，唯一三角形的分数为 6。 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[3,7,4,5] 输出：144 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。 示例 3：
 * <p>
 * 输入：[1,3,1,4,1,5] 输出：13 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 50 1 <= A[i] <= 100 区间DP算法
 *
 * @author yukong
 * @date 2020/6/26 22:39
 */
public class Solution {
    // dp[i][j] = Math.min(dp[i, k=j], dp[i, k] + dp[k + 1, j] + nums[i] * nums[k] *nums[j])
    public int minScoreTriangulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = len + i - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + nums[i] * nums[k] * nums[j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    int[][] mem = null;

    // dfs + memory
    public int minScoreTriangulation1(int[] nums) {
        int n = nums.length;
        mem = new int[n][n];
        return dfs(nums, 0, n - 1);
    }

    private int dfs(int[] nums, int left, int right) {
        if (mem[left][right] != 0) {
            return mem[left][right];
        }
        if (left + 1 == right) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, dfs(nums, left, i) + dfs(nums, i, right) + nums[left] * nums[i] * nums[right]);
        }
        mem[left][right] = ans;
        return ans;
    }
}
