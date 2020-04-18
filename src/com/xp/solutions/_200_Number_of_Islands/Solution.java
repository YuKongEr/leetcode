package com.xp.solutions._200_Number_of_Islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/18 20:48
 */
public class Solution {
    private int[][] direct = new int[][]{{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    // bfs
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int landCount = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    landCount++;
                }
            }
        }
        return landCount;
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        grid[x][y] = 'x';
        queue.offer(new int[]{x, y});
        int nr = grid.length;
        int nc = grid[0].length;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] temp = queue.poll();
            while (size-- > 0) {
                for (int[] ints : direct) {
                    int x1 = ints[0] + temp[0];
                    int y1 = ints[1] + temp[1];
                    if (x1 >= 0 && x1 < nr && y1 >= 0 && y1 < nc && grid[x1][y1] == '1') {
                        queue.offer(new int[]{x1, y1});
                        grid[x1][y1] = 'x';
                    }
                }
            }
        }
    }
    // dfs
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int landCount = 0;
//        int nr = grid.length;
//        int nc = grid[0].length;
//        for (int i = 0; i < nr; i++) {
//            for (int j = 0; j < nc; j++) {
//                if (grid[i][j] == '1') {
//                    landCount++;
//                    spred(grid, i, j);
//                }
//            }
//        }
//        return landCount;
//    }
//
//    private void spred(char[][] grid, int i, int j) {
//        // 标志已经被访问
//        grid[i][j] = 'x';
//        int nr = grid.length;
//        int nc = grid[0].length;
//        for (int[] ints : direct) {
//            int x1 = ints[0] + i;
//            int y1 = ints[1] + j;
//            if (x1 >= 0 && x1 < nr && y1 >= 0 && y1 < nc && grid[x1][y1] == '1') {
//               spred(grid, x1, y1);
//            }
//        }
//
//    }

    // 归并集
//    static class Union {
//        private int count;
//        private int[] boss;
//        public Union(char[][] grid) {
//            count = 0;
//            int m = grid.length;
//            int n = grid[0].length;
//            boss = new int[m * n];
//            for (int i = 0; i < m; ++i) {
//                for (int j = 0; j < n; ++j) {
//                    if (grid[i][j] == '1') {
//                        boss[i * n + j] = i * n + j;
//                        ++count;
//                    }
//                }
//            }
//        }
//
//        public int find(int x) {
//            if (boss[x] != x) {
//                boss[x] = find(boss[x]);
//            }
//            return boss[x];
//        }
//
//        public void union(int x, int y) {
//            int bossX = find(x);
//            int bossY = find(y);
//            if(bossX != bossY) {
//                boss[bossY] = bossX;
//                count--;
//            }
//        }
//    }
//
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int nr = grid.length;
//        int nc = grid[0].length;
//        Union union = new Union(grid);
//        for (int i = 0; i < nr; i++) {
//            for (int j = 0; j < nc; j++) {
//                if(grid[i][j] == '1') {
//                    for (int[] ints : direct) {
//                        int x1 = ints[0] + i;
//                        int y1 = ints[1] + j;
//                        if(x1 >=0 && x1 < nr && y1 >= 0 && y1 <nc && grid[x1][y1] == '1') {
//                            union.union(x1 * nc + y1, i * nc + j);
//                        }
//                    }
//                }
//            }
//        }
//        return union.count;
//    }


}
