package com.xp.solutions._76_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukong
 * @date 2020/5/23 09:59
 */
public class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> currentWindow = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0) + 1);
        }
        int match = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < s.length()) {
            char ch = s.charAt(right);
            // 如果是需要的字符
            if(needs.containsKey(ch)) {
                // 则加入当前窗口
                currentWindow.put(ch, currentWindow.getOrDefault(ch, 0) + 1);
                // 如果出现次数相同 则增加匹配次数
                    if(needs.get(ch).intValue() == currentWindow.get(ch)) {
                    match++;
                }
            }
            right++;
            // 如果匹配次数 等于need中字符的数量 则代表当前窗口已经全部包含needs的字符了
            while(match == needs.size()) {
                if (right - left < minLen) {
                    // 更新最小子串的位置和⻓度 start = left;
                    minLen = right - left;
                    start = left;
                }
                char cc = s.charAt(left);
                if(needs.containsKey(cc)) {
                    currentWindow.put(cc, currentWindow.get(cc) - 1);
                    if(currentWindow.get(cc) < needs.get(cc)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC","ABC"));
    }
}
