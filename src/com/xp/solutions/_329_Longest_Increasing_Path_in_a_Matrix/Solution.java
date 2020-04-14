package com.xp.solutions._329_Longest_Increasing_Path_in_a_Matrix;

import java.util.Arrays;

/**
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
