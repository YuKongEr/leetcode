package com.xp.solutions._387_First_Unique_Character_in_a_String;

/**
 * 387. 字符串中的第一个唯一字符 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode" 返回 0.
 * <p>
 * s = "loveleetcode", 返回 2.
 * <p>
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author yukong
 * @date 2020/3/19 20:39
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];
        for (char ch: s.toCharArray()) {
            charCount[ch - 'a'] = charCount[ch - 'a'] + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
