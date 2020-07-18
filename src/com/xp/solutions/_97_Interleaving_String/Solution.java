package com.xp.solutions._97_Interleaving_String;

/**
 * 97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 *
 * @author yukong
 * @date 2020/7/18 09:50
 */
public class Solution {
    /**
     * 可定义boolean[][] dp ，dp[i][j]代表s1前i个字符与s2前j个字符拼接成s3的i+j字符，也就是存在目标路径能够到达i,j；
     * 状态方程：
     * <p>
     * 边界1：dp[0][0] = true;
     * 边界2：if i=0 : dp[0]dp[j] = s2[0-j) equals s3[0,j) 遇到false后面可以直接省略
     * 边界3：if j=0 : dp[i]dp[0] = s1[0-i) equals s3[0,i) 遇到false后面可以直接省略
     * <p>
     * 其他情况，到达i，j可能由i-1,j点选择s1[i-1]到达；也可能由i,j-1点选择s2[j-1]到达；
     * dp[i,j] = (dp[i-1][j] && s3[i+j-1] == s1[i-1]) || (dp[i][j-1] && s3[i+j-1] == s2[j-1])
     * <p>
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) {
            return false;
        }
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                int s3Index = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(s3Index)));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(s3Index)));
                }
            }
        }
        return dp[n1][n2];
    }
}
