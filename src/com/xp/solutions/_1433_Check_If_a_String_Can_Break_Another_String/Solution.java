package com.xp.solutions._1433_Check_If_a_String_Can_Break_Another_String;

/**
 * @author yukong
 * @date 2020/6/10 13:52
 */
public class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];

        for (char c : s1.toCharArray()) {
            chars1[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            chars2[c - 'a']++;
        }
        int start = 0;

        for (; start < 26; start++) {
            if (chars1[start] > chars2[start]) {
                int[] temp = chars1;
                chars1 = chars2;
                chars2 = temp;
                break;
            }
            if (chars1[start] < chars2[start]) {
                break;
            }
        }

        int count1 = 0;
        int count2 = 0;
        // s1 打破 s2
        for (; start < 26; start++) {
            count1 += chars1[start];
            count2 += chars2[start];
            // 同一个长度下 打破的字符串的前缀和应该小于 被打破的字符串 例如 aab 打破 aaa那么在字符相同情况a下  打破字符串的前缀和为2  被打破字符串为3
            if (count1 > count2) {
                return false;
            }
        }
        return true;
    }
}
