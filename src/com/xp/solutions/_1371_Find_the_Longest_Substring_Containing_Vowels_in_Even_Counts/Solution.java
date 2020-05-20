package com.xp.solutions._1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts;

import java.util.Arrays;

/**
 * @author yukong
 * @date 2020/5/20 22:40
 */
public class Solution {
    public int findTheLongestSubstring(String s) {
        int ans = 0;
        // 记录每种状态第一次出现的位置
        int[] pos = new int[ 1 << 5];
        Arrays.fill(pos, -1);

        int status = 0;
        pos[0] = 0;
        // 默认全是00000 认为是偶数
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'a') {
                status ^= (1 << 0);
            } else if(ch == 'e') {
                status ^= (1 << 1);
            } else if(ch == 'i') {
                status ^= (1 << 2);
            } else if(ch == 'o') {
                status ^= (1 << 3);
            } else if(ch == 'u') {
                status ^= (1 << 4);
            }
            if(pos[status] >= 0) {
                // 如果这个状态已经出现过 那么从pos[status] 到 i这个位置中的元音就是出现为偶数
                // 因为奇数-奇数=偶数 偶数-偶数=偶数
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                // 记录第一次当前状态出现的位点
                pos[status] = i + 1 ;
            }
        }
        return ans;

    }
}
