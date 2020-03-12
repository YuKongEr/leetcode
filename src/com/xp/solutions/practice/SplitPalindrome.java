package com.xp.solutions.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yukong
 * @date 2020/3/11 17:00
 */
public class SplitPalindrome {

    /*

    解法一 分治
    将大问题分解为小问题，利用小问题的结果，解决当前大问题。

    这道题的话，举个例子。

    aabb
    先考虑在第 1 个位置切割，a | abb
    这样我们只需要知道 abb 的所有结果，然后在所有结果的头部把 a 加入
    abb 的所有结果就是 [a b b] [a bb]
    每个结果头部加入 a，就是 [a a b b] [a a bb]

    aabb
    再考虑在第 2 个位置切割，aa | bb
    这样我们只需要知道 bb 的所有结果，然后在所有结果的头部把 aa 加入
    bb 的所有结果就是 [b b] [bb]
    每个结果头部加入 aa,就是 [aa b b] [aa bb]

    aabb
    再考虑在第 3 个位置切割，aab|b
    因为 aab 不是回文串，所有直接跳过

    aabb
    再考虑在第 4 个位置切割，aabb |
    因为 aabb 不是回文串，所有直接跳过

    最后所有的结果就是所有的加起来
    [a a b b] [a a bb] [aa b b] [aa bb]
    然后中间的过程求 abb 的所有结果，求 aab 的所有结果等等，就可以递归的去求。递归出口的话，就是空串的所有子串就是一个空的list 即可。

    作者：windliang
    链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa
    -by-3-7/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<List<String>> partition(String s) {
        return partitionHelper(s, 0);
    }

    private List<List<String>> partitionHelper(String s, int start) {
        // 分治算法到最后一个字符
        if(s.length() == start) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            //当前切割后是回文串才考虑
            if (isPalindrome(s.substring(start, i + 1))) {
                String left = s.substring(start, i + 1);
                //遍历后边字符串的所有结果，将当前的字符串加到头部
                for (List<String> l : partitionHelper(s, i + 1)) {
                    l.add(0, left);
                    ans.add(l);
                }
            }

        }
        return ans;
    }


    private boolean isPalindrome(String s) {
        int p = 0, q = s.length() - 1;
        while (p < q) {
            if(s.charAt(p) != s.charAt(q)) {
                return false;
            }
            p++;
            q--;
        }
        return true;
    }


    */
    public static void main(String[] args) {
          System.out.println(new SplitPalindrome().partition("aab"));
    }

    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        return partitionHelper(s, dp, 0);
    }

    private List<List<String>> partitionHelper(String s, boolean[][] dp, int start) {
        if (s.length() == start) {
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                String left = s.substring(start, i + 1);
                for (List<String> l : partitionHelper(s, dp, i + 1)) {
                    l.add(0, left);
                    ans.add(l);
                }
            }
        }
        return ans;
    }


}
