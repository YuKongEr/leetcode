package com.xp.solutions.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。 你可以假设字典中没有重复的单词。 示例 1：
 * <p>
 * 输入: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"] 输出: [ "cats and dog", "cat sand dog" ] 示例 2：
 * <p>
 * 输入: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen", "pine", "pineapple"] 输出: [ "pine apple pen
 * apple", "pineapple pen apple", "pine applepen apple" ] 解释: 注意你可以重复使用字典中的单词。 示例 3：
 * <p>
 * 输入: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"] 输出: []
 *
 * @author yukong
 * @date 2020/3/15 20:00
 */
public class WordSplit2 {
    /**
     * 解法一、 回溯算法 解决此题最简单的方法是使用回溯。为了找到解，我们检查字符串（ss）的所有可能前缀是否在字典中，如果在（比方说 s1s1 ）， 那么调用回溯函数并检查剩余部分的字符串。
     * 如果剩余部分可以形成有效拆分，这个函数返回前缀 s1 ，并将回溯调用的剩余结果（即 s−s1）跟在 s1 的后面。否则，返回空列表。
     * 使用Hashmap作为备忘录 给回溯树剪支
     */


    HashMap<Integer, List<String>> map = new HashMap<>();



    public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 0; j < i ; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        if(dp[s.length()]) {
            ans = dfs(s, wordDict, 0, dp);
        }
        return ans;
    }

    public List<String> dfs(String s, List<String> wordDict, int start, boolean[] dp) {
        if (map.containsKey(start)) {
            return map.get(start);
        }

        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start; end <= s.length(); end++) {
            if (dp[start] && wordDict.contains(s.substring(start, end))) {
                List<String> temp = dfs(s, wordDict, end, dp);
                for (String str : temp) {
                    res.add(s.substring(start, end) + ("".equals(str) ? "" : " ") + str);
                }
            }
        }
        map.put(start, res);
        return res;
    }



    /**
     * 动态规划算法
     * dp[i]表示以i结尾的子串存在字典中的 字符串分割
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> dp(String s, List<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        // break case
        LinkedList<String> init = new LinkedList<>();
        init.add("");
        dp[0] = init;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> linkedList = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                // dp[j].size() > 0 代表 已经j结尾的字符串存在字典的连接串
                if(dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String str: dp[j]) {
                        linkedList.add(str + ("".equals(str) ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = linkedList;
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("apple");
        dict.add("pen");
        dict.add("applepen");
        dict.add("pine");
        dict.add("pineapple");
        System.out.println(new WordSplit2().wordBreak("pineapplepenapple", dict));
    }
}
