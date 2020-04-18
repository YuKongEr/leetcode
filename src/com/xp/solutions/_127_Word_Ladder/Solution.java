package com.xp.solutions._127_Word_Ladder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/15 22:54
 */
public class Solution {
    // bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // visited修改为boolean数组
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            visited[idx] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                count++;
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited[j]) {
                        continue;
                    }
                    String s = wordList.get(j);
                    if (!canConvert(word, s)) {
                        continue;
                    }
                    if (endWord.equals(s)) {
                        return ++count;
                    }
                    queue.offer(s);
                    visited[j] = true;
                }
            }

        }
        return 0;
    }


    private boolean canConvert(String s1, String s2) {
        // 因为题目说了单词长度相同，可以不考虑长度问题
        // if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        new Solution().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }

}
