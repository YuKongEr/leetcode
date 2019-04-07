package com.xp.solutions._516_Longest_Palindromic_Subsequence;

/**
 * @author yukong
 * @date 2019-03-18 15:48
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 * 实现： 动态规划算法
 * dp[i][j]表示下标从i-j最长回文子串的长度
 * dp[i][i] =1
 * dp[i][j] = 2 if(j == i+1 && s[i] == s[j])
 * if(s[i] == s[j]) {
 *     dp[i][j] = dp[i+1][j-1] + 2
 * } else {
 *     dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
 * }
 */
public class Solution {

    /*public  static int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            if(i < (s.length() - 1) ) {
                if (s.charAt(i) == s.charAt(i + 1)){
                    dp[i][i + 1] = 2;

                }
                else {
                    dp[i][i + 1] = 1;

                }
            }

        }
        for (int l = 2; l < s.length(); l++) {
            for (int i = 0; i < s.length() && (i + l) < s.length(); i++) {
                if(s.charAt(i) == s.charAt(i + l )){
                    dp[i][i + l] = dp[i+1][i + l -1] +2;
                } else {
                    dp[i][i + l] = Math.max(dp[i+1][i+l],dp[i][i+l-1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }*/

    public   int longestPalindromeSubseq(String s) {
        if(s == null || s.length() < 2){
            return s.length();
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int start = 0; start < s.length(); start++) {
            dp[start][start] = 1;
            for (int end = start - 1; end >= 0 ; end--) {
                if(s.charAt(start) == s.charAt(end)){
                    dp[start][end] = dp[start - 1][end + 1] + 2;
                } else {
                    dp[start][end] = Math.max(dp[start-1][end], dp[start][end + 1]);
                }
            }
        }

        return dp[s.length() - 1][0];

    }

    public static void main(String[] args) {

        String s1 = new String("aa");
        String s2 = new String("aa");
        System.out.println(s1 == s2);
        String s3 = s1.intern();
        String s4 = s1.intern();

        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);

    }
}
