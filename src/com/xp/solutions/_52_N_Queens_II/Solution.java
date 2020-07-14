package com.xp.solutions._52_N_Queens_II;

/**
 * 52. N皇后 II
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
 *
 * @author yukong
 * @date 2020/7/14 13:45
 */
public class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        backtrack(n, 0, new int[n]);
        return count;
    }

    /**
     * 回溯算法
     * @param n 皇后个数
     * @param row 当前摆放的行
     * @param cols 已经放了皇后位置的标识数组
     */
    private void backtrack(int n, int row, int[] cols) {
        // 结束条件 每一行都放了 那就结束

        if (n == row) {
            System.out.print(n);
            count++;
            return;
        }
        // 遍历当前行的每一列 判断皇后能不能放在这一行的这一列
        for (int col = 0; col < n; col++) {
            //标记当前行皇后的摆放位置
            cols[row] = col;
            // 判断是否能放
            if (check(row, col, cols)) {
                backtrack(n, row + 1, cols);
            }
            cols[row] = -1;
        }
    }

    /**
     * 判断皇后摆放是否冲突
     * @param row 行
     * @param col 列
     * @param cols 已经放了皇后位置的标识数组
     * @return 当前row col是否能放一个皇后
     */
    private boolean check(int row, int col, int[] cols) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col || Math.abs(row - i) == Math.abs(cols[i] - col)) {
                return false;
            }
        }
        return true;
    }
}
