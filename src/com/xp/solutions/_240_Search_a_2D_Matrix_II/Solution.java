package com.xp.solutions._240_Search_a_2D_Matrix_II;

/**
 * 240. 搜索二维矩阵 II 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。 每列的元素从上到下升序排列。 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [ [1,   4,  7, 11, 15], [2,   5,  8, 12, 19], [3,   6,  9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30] ] 给定
 * target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 *
 * @author yukong
 * @date 2020/3/19 23:25
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] < target) {
                column++;
            } else if (matrix[row][column] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
