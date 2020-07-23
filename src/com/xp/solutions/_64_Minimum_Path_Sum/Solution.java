package com.xp.solutions._64_Minimum_Path_Sum;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @author: yukong
 * @date: 2018/11/16 10:29
 */
public class Solution {


    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;

        }
        int more = Math.max(grid.length, grid[0].length);
        int min = Math.min(grid.length, grid[0].length);
        boolean rowMore = grid.length > grid[0].length;
        int[] arr = new int[min];
        arr[0] = grid[0][0];
        for (int i = 1; i < min; i++) {
            arr[i] = arr[i-1] + (rowMore ? grid[0][i] : grid[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowMore ? grid[i][0] : grid[0][i]);
            for (int j = 1; j < min ; j++) {
                arr[j] = (rowMore ?grid[i][j] :  grid[j][i]) + Math.min(arr[j], arr[j-1]);
            }
        }
        return arr[min-1];

    }

    public int minPathSum1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }


    public static void main(String[] args) {
        int[][] arr ={{1,2,5},{3,2,1}};
        System.out.println(new Solution().minPathSum(arr));
    }
}
