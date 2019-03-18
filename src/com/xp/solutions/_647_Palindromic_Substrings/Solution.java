package com.xp.solutions._647_Palindromic_Substrings;

/**
 * @author yukong
 * @date 2019-03-18 15:00
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 * 解答： 动态规划
 * dp[i][j] 表示下标从i到j的元素是否是回文串  true是 false不是
 * dp[i][j] == true if(i == j) 单个字符
 * dp[i][j] == true if(j == i + 1 && s[i] == s[j])
 * dp[i][j] == dp[i+1][j-1] && (s[i] == s[j])
 */
public class Solution {


    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
            if(i < (s.length() - 1) && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        for (int l = 2; l < s.length(); l++) {
            for (int i = 0; i < s.length() && i + l <s.length(); ++i) {
                dp[i][i + l] = dp[i + 1][i + l -1] && s.charAt(i) == s.charAt(i + l);
                if(dp[i][i + l]){
                    count++;
                }
            }
        }
        return count;
    }

}
