package com.xp.solutions._5_Longest_Palindromic_Substring;

/**
 * Description: User: yukong Date: 2018-01-16 Time: 16:06
 */
public class Solution {

    public static String longestPalindrome(String s) {

        // dp[i][j] = 是否为回文串
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0, len = -1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                boolean isEqual = s.charAt(i) == s.charAt(j);
                // 1、如果i == j 那么肯定是回文字符串
                // 2、如果 s.charAt(i) == s.charAt(j) 且中间为空 那么就是aa bb这种情景 此时j = i + 1;
                // 3、如果 s.charAt(i) == s.charAt(j) 且中间为不为空 那么需要中间的字符串也是回味字符串 即dp[i+1][j-1] == true;
                if (j == i
                        || (isEqual && j - i == 1)
                        || (isEqual && dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i > len) {
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
