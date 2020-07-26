package com.xp.solutions._329_Longest_Increasing_Path_in_a_Matrix;


/**
 * 329. 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 * @author yukongcode@gmail.com
 * @date 2020/4/9 22:13
 */
public class Solution {

    private int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[][] mem = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                max = Math.max(max, dfs(i, j, matrix, mem));
            }
        }
        return max;
    }

    private int dfs(int x, int y, int[][] matrix, int[][] mem) {

        if (mem[x][y] != 0) {
            return mem[x][y];
        }
        for (int[] d : direct) {
            int i = x + d[0];
            int j = y + d[1];
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length && matrix[x][y] > matrix[i][j]) {
                mem[x][y] = Math.max(mem[x][y], dfs(i, j, matrix, mem));
            }
        }
        return ++mem[x][y];
    }
}
