package com.xp.solutions._3_Longest_Substring_Without_Repeating_Characters;

/**
 * Description:
 * User: yukong
 * Date: 2018-01-15
 * Time: 15:14
 */
public class Solution {
    public  int lengthOfLongestSubstring(String s) {
        int idx = 0;  // 遍历下标
        int maxLength = 0; // 最大长度
        int maxStart = 0;  // 最大长度的开始下标
        int length = 0; // 遍历时无重复字符串的长度
        int start = 0;  //遍历时无重复字符串的开始下标
        char[] hash = new char[256]; //字符是否重复的hash表 默认0未访问  1 已访问

        while (idx < s.length()) {
            if ( hash[s.charAt(idx)] == 1) {
                if (length > maxLength) {
                    maxLength = length;
                    maxStart = start;
                }

                //重置之前已访问的标记
                while (s.charAt(start) != s.charAt(idx)) {
                    hash[s.charAt(start)] = 0;  //重置
                    length--;
                    start++;
                }
                start++;

            } else{
                length++;
                hash[s.charAt(idx)] = 1;  //标记为已访问
            }
            idx++;
        }

        if (length > maxLength) {
            maxLength = length;
            maxStart = start;
        }
        return maxLength;
    }


}
