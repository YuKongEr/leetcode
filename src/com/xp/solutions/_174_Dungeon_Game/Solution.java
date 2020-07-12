package com.xp.solutions._174_Dungeon_Game;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 * <p>
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * <p>
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * <p>
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 *
 * @author yukong
 * @date 2020/7/12 20:06
 */
public class Solution {
    int[][] mem;

    public int calculateMinimumHP(int[][] dungeon) {
        mem = new int[dungeon.length + 1][dungeon[0].length + 1];
        return dfs(dungeon, 0, 0, dungeon.length - 1, dungeon[0].length - 1);
    }

    /**
     * 从出发点开始，DFS 搜索到终点的所有的路径。
     * 在每个点，我们可以选择向右搜或者向下搜（最后一行/列除外）。
     * <p>
     * 因此，求从 (0, 0) 出发到终点的最小初始值 dfs(0, 0)，可以转化为先求 dfs(1, 0) 和 dfs(0, 1)，取其中较小的一个，
     * 即min(dfs(0, 1), dfs(1, 0))，作为 (0, 0)点的后续路径所要求的最低血量。又因为 (0, 0) 点本身就提供血量 dungoen[0][0]，
     * 因此从 (0, 0) 点出发所需的血量为后续路径所需要的最低血量减去 (0, 0)点提供的血量，即 min(dfs(0, 1), dfs(1, 0)) - dungoen[0][0]（这里写代码时要注意骑士的血量不能小于 1）。
     * <p>
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/dungeon-game/solution/jian-dan-dfskan-yi-yan-jiu-ming-bai-e-by-sweetiee/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param dungeon
     * @param i
     * @param j
     * @param n
     * @param m
     * @return
     */
    private int dfs(int[][] dungeon, int i, int j, int n, int m) {
        // 终点
        if (i == n && j == m) {
            return Math.max(1 - dungeon[i][j], 1);
        }
        // 备忘录
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        int res = 0;
        // 行边界
        if (i == n) {
            res = Math.max(dfs(dungeon, i, j + 1, n, m) - dungeon[i][j], 1);
        }
        // 列边界
        else if (j == m) {
            res = Math.max(dfs(dungeon, i + 1, j, n, m) - dungeon[i][j], 1);
        } else {
            res = Math.max(Math.min(dfs(dungeon, i, j + 1, n, m), dfs(dungeon, i + 1, j, n, m)) - dungeon[i][j], 1);
        }
        mem[i][j] = res;
        return res;
    }

    /**
     * dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j], 1)
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP1(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
