package com.xp.solutions._139_Word_Break;

/**
 * 139. 单词拆分 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。 你可以假设字典中没有重复的单词。 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"] 输出: true 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"] 输出: true 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen
 * apple"。 注意你可以重复使用字典中的单词。 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] 输出: false 通过次数63,595提交次数139,271 在真实的面试中遇到过这道题？
 *
 * @author yukong
 * @date 2020/6/25 12:53
 */
public class Solution {

    // dp[j] = dp[i] && checkContains(substring(i, j)) j >= i
    public boolean wordBreak(String s, List<String> wordDict) {
        //     boolean[] dp = new boolean[s.length() + 1];
        //     dp[0] = true;
        //     for(int i = 0; i <= s.length(); i++) {
        //          for(int j = i; j <= s.length(); j++) {
        //              if(dp[i] && wordDict.contains(s.substring(i, j))) {
        //                  dp[j] = true;
        //              }
        //          }
        //     }
        //     return dp[s.length()];
        // Set<String> wordDictSet = new HashSet(wordDict);
        // boolean[] dp = new boolean[s.length() + 1];
        // dp[0] = true;
        // for (int i = 1; i <= s.length(); i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // }
        // return dp[s.length()];

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (String s1 : wordDict) {
                if (s1.length() > i) {
                    dp[i] = false;
                    continue;
                }
                if (dp[i - s1.length()] && s.substring(i - s1.length(), i).equals(s1)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

}
