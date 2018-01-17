package com.xp.solutions._5_Longest_Palindromic_Substring;

/**
 * Description:
 * User: yukong
 * Date: 2018-01-16
 * Time: 16:06
 */
public class Solution {

    public static String longestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }

        int max = -1;
        String res = null;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    res = s.substring(i,j + 1);
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcda"));
    }

}
