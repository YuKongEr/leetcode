package com.xp.solutions.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
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
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] 输出: false
 * <p>
 * 首先我们要解决的是字符串 s 是否能够被字典中的单词来表示，也就是得有 res[i] 数据，表示到字符串 s 的第 i 个元素为止能不能用字典中的词来表示。因此，我们需要一个长度为 n 的布尔数组来存储这些信息。
 * <p>
 * 然后假设我们现在拥有 res[0,…,i-1] 的结果，我们来获得 res[i] 的表达式。思路是对于每个以 i 为结尾的子串，看看他是不是在字典里面以及他之前的元素对应的 res[j] 是不是 true ，如果都成立，那么
 * res[i] 为 true
 *
 * @author yukong
 * @date 2020/3/14 16:25
 */
public class WordSplit {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // res[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] res = new boolean[n + 1];
        res[0] = true;
        for (int end = 1; end <= n; end++) {
            for (int start = 0; start < end; start++) {
                if (res[start] && wordDict.contains(s.substring(start, end))) {
                    res[end] = true;
                    break;
                }
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        System.out.println(new WordSplit().wordBreak("applepenapple", list));
    }
}
