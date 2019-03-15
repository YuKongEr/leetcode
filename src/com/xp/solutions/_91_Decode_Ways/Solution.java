package com.xp.solutions._91_Decode_Ways;

import java.util.HashMap;

/**
 * @author yukong
 * @date 2019-03-15 09:21
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Solution {
/*
    HashMap<Integer, Integer> counts = new HashMap<>();

    *//**
     * 递归实现
     * @param s
     * @return
     *//*
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.charAt(0) == '0'){
            return 0;
        }
        return ways(s,0, s.length() - 1);
    }

    public int ways(String s, int l ,int r){
        if(counts.containsKey(l)){
            return counts.get(l);
        }
        if(s.charAt(l) == '0'){
            return 0;
        }
        // 单个字符
        if(l >= r){
            return 1;
        }

        int w = ways(s, l + 1, r);

        int prefix = (s.charAt(l) - '0') * 10 + (s.charAt(l + 1) - '0');
        if(prefix >= 1 && prefix <= 26){
            w += ways(s, l+2, r);
        }

        counts.put(l, w);
        return w;
    }*/


    public int numDecodings(String s) {
        if(s.length() < 1){
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        int curr = 2;
        while (curr <= s.length()){
            int prefix = (s.charAt(curr - 2) - '0') * 10 + (s.charAt(curr - 1) - '0');
            if(s.charAt(curr - 1) != '0'){
                dp[curr] += dp[curr-1];
            }
            if(prefix >= 10 && prefix <= 26){
                dp[curr] += dp[curr - 2];
            }
            curr++;
        }
        return dp[s.length()];
    }



}
