package com.xp.solutions._1254_Number_of_Closed_Islands;

/**
 * 1254. 统计封闭岛屿的数目 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * <p>
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * <p>
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * <p>
 * 请返回封闭岛屿的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]] 输出：2 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]] 输出：1 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1], [1,0,0,0,0,0,1], [1,0,1,1,1,0,1], [1,0,1,0,1,0,1], [1,0,1,1,1,0,1], [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]] 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[0].length <= 100 0 <= grid[i][j] <=1
 *
 * @author yukong
 * @date 2020/6/20 23:44
 */
public class Solution {

    private int[][] direct = new int[][]{{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islandCount = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 0 && isClosed(grid, i, j)) {
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    // dfs
    private boolean isClosed(int[][] grid, int i, int j) {
        // 边沿岛屿不能算封闭
        if (i == 0 || i == grid.length - 1) {
            return false;
        }
        if (j == 0 || j == grid[0].length - 1) {
            return false;
        }
        if ( grid[i][j] == 1) {
            return true;
        }
        // 标记已经访问
        grid[i][j] = 1;
        // 遍历四个方向
        boolean res = true;
        for (int[] ints : direct) {
            int newRow = i + ints[0];
            int newCol = j + ints[1];
            if(grid[newRow][newCol] == 0) {
                // isClose 判断在前保证进行陆地染色 如果res在前且 res是false 会导致isClose方法不执行 从而相邻的陆地没有染色导致结果错误。
                res =  isClosed(grid, newRow, newCol) && res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0,
                        1}, {1, 1, 1, 1, 1, 1, 1, 0}};

        System.out.println(new Solution().closedIsland(grid));

    }
}
