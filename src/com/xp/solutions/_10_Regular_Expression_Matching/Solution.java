package com.xp.solutions._10_Regular_Expression_Matching;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._10_Regular_Expression_Matching
 * @Description: TODO
 * @date 2018/1/19 09:17
 **/
public class Solution {


    //原题

    /**
     * Implement regular expression matching with support for '.' and '*'.

     '.' Matches any single character.
     '*' Matches zero or more of the preceding element.

     The matching should cover the entire input string (not partial).

     The function prototype should be:
     bool isMatch(const char *s, const char *p)

     Some examples:
     isMatch("aa","a") → false
     isMatch("aa","aa") → true
     isMatch("aaa","aa") → false
     isMatch("aa", "a*") → true
     isMatch("aa", ".*") → true
     isMatch("ab", ".*") → true
     isMatch("aab", "c*a*b") → true
     */

    //解题思路


    /**
     * 1）划分阶段：
     * <p>
     * （2）确定状态：dp[i][j]（代表s[:i-1]和p[:j-1]是否match）
     * <p>
     * （3）边界条件：
     * <p>
     * A. dp[0][0] = True (代表两个空数组match)
     * <p>
     * B. dp[i][0] = False (代表s为空，p不为空则必然不匹配)
     * <p>
     * C. dp[0][j] = dp[0][j-2] if p[j-1]=='*' and j>=2
     * <p>
     * （4）状态转移方程：(分情况考虑)
     * <p>
     * A. p[j] != '*' 时，
     * <p>
     * if p[j] != '*' :
     * <p>
     * dp[i+1][j+1] = dp[i][j] and (s[i] == p[j] or p[j] == '.' )
     * <p>
     * B. p[j] == '*' : （重点考虑该情况）
     * <p>
     * if  p[j] == '*' :
     * <p>
     * a. 该 '*' match了s中的0个字符：【注：该处（及下方）提到的match了x个字符都是就当前而言的，不考虑s及p的第i、j之后的字符match情况】
     * <p>
     * dp[i+1][j+1] = dp[i+1][j-1]
     * <p>
     * b. 该 '*' match了s中的1个字符：
     * <p>
     * dp[i+1][j+1] = dp[i][j-1] and(s[i] == p[j-1] or p[j-1] == '.' )
     * <p>
     * c. 该 '*' match了s中的多个字符：
     * <p>
     * dp[i+1][j+1] = dp[i][j+1] and (s[i] == p[j-1] or p[j-1] == '.' )
     *
     * @param s
     * @param p
     * @return
     */

    public static boolean isMatch(String s, String p) {

        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];

        match[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                match[0][i + 1] = match[0][i - 1];
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j - 1) != '*') {
                    match[i][j] = match[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                } else if (p.charAt(j - 1) == '*') {
                    match[i][j] = (match[i ][j - 2]
                            || (match[i - 1][j - 2] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'))
                            || (match[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'))
                    );
                }

            }
        }

        return match[s.length()][p.length()];

    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab","b.*"));
    }

    /*
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return false;
        }

        if (p.length() == 1 ) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }

        // 无*
        if (p.charAt(1) != '*') {
            if (s.length() == 0) {
                return false;
            } else {
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '0') && isMatch(s.substring(1), s.substring(1));
            }
            // 有*
        } else {
            while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);

            }
            return isMatch(s, p.substring(2));
        }
    }
    */
}
