package com.xp.solutions.practice;

import java.util.Arrays;

/**
 * 有效的字母异位词 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram" 输出: true 示例 2:
 * <p>
 * 输入: s = "rat", t = "car" 输出: false
 *
 * @author yukong
 * @date 2020/3/17 21:26
 */
public class EctopicString {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        return new String(ss).equals(new String(ts));
    }
}
