package com.xp.solutions._72_Edit_Distance;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukong
 * @date 2020/6/28 21:24
 */
public class Solution {
    // dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j -1] +  [if s[i] == t[j] 0 else 1])
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i - 1][j];
                int right = dp[i][j - 1];
                int mid = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    mid += 1;
                }
                dp[i][j] = Math.min(mid, Math.min(left + 1, right + 1));
            }
        }
        return dp[m][n];
    }


    Map<Pair<Integer, Integer>, Integer> mem = new HashMap<>();

    private int minDistance1(String word1, String word2) {
        return dfs(word1, word1.length(), word2, word2.length());
    }

    private int dfs(String word1, int p, String word2, int q) {
        if (p == 0) {
            return word2.length();
        }
        if (q == 0) {
            return word1.length();
        }
        if (mem.get(new Pair(p, q)) != null) {
            return mem.get(new Pair(p, q));
        }
        int min = 0;
        if (word1.charAt(p) == word2.charAt(q)) {
            min = dfs(word1, p - 1, word2, q - 1);
        } else {
            min = Math.min(dfs(word1, p - 1, word2, q), Math.min(dfs(word1, p, word2, q - 1), dfs(word1, p - 1,
                    word2, q - 1))) + 1;
        }
        mem.put(new Pair(p , q), min);
        return min;
    }
}
