package com.xp.solutions._395_Longest_Substring_with_At_Least_K_Repeating_Characters;

/**
 * @author yukong
 * @date 2020/4/4 23:18
 */
public class Solution {

    /*
   找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。
   注意: 不要求连续,只要存在多余等于k个就行, 使用数组来存'频率':time
   */

    public int longestSubstring(String s, int k) {
        return longestSubstring(s, 0, s.length() - 1, k);
    }

    public int longestSubstring(String s, int begin, int end, int k) {
        if (end - begin + 1 < k) {
            return 0;
        }
        int[] chs = new int[26];
        // 计算出现次数
        for (int i = begin; i <= end; i++) {
            chs[s.charAt(i) - 'a'] = chs[s.charAt(i) - 'a'] + 1;
        }
        // 跳过 次数小于k的
        while (begin < end && chs[s.charAt(begin) - 'a'] < k) {
            begin++;
        }
        while (begin < end && chs[s.charAt(end) - 'a'] < k) {
            end--;
        }
        if (end - begin + 1 < k) {
            return 0;
        }
        // 分而治之
        for (int i = begin; i <= end; i++) {
            if (chs[s.charAt(i) - 'a'] < k) {
                return Math.max(longestSubstring(s, begin, i - 1, k), longestSubstring(s, i + 1, end, k));
            }
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
        //  new Solution().longestSubstring("weitong", 3);
        // new Solution().longestSubstring("aaabb", 3);
        System.out.println(new Solution().longestSubstring("aacbbbdc", 2));
        ;
    }
}
