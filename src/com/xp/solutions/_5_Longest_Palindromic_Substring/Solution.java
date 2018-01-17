package com.xp.solutions._5_Longest_Palindromic_Substring;

/**
 * Description:
 * User: yukong
 * Date: 2018-01-16
 * Time: 16:06
 */
public class Solution {

    public static String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return null;
        }
        int start = 0;
        int end = 0;
        int len = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j || (s.charAt(i) == s.charAt(j) && j - i < 2)
                        || (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > len) {
                        len = j - i;
                        start = i;
                        end = j + 1;
                    }
                }

            }
        }
        return s.substring(start, end);
    }

}
