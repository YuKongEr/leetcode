package com.xp.solutions._392_Is_Subsequence;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 后续挑战 :
 *
 * @author yukong
 * @date 2020/7/27 20:36
 */
public class Solution {//     public boolean isSubsequence(String s, String t) {
//        if (s.length() == 0)
//             return true;
//         boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
//         for (int i = 0; i < t.length(); i++) {
//             dp[0][i] = true;
//         }
//         for (int i = 1; i <= s.length(); i++) {
//             for (int j = 1; j <= t.length(); j++) {
//                 if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = dp[i][j - 1];
//                 }
//             }
//         }
//         return dp[s.length()][t.length()];

    //     }
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            //index表示上一次查找的位置(第一次查找的时候为-1)，所以这里要从t的下标(index+1)开始查找
            index = t.indexOf(c, index + 1);
            //没找到，返回false
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
