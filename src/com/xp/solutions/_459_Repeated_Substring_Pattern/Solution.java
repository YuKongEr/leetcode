package com.xp.solutions._459_Repeated_Substring_Pattern;

/**
 * @author yukong
 * @date 2020/8/24 15:10
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
