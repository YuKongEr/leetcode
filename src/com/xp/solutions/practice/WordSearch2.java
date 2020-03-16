package com.xp.solutions.practice;

import java.util.*;

/**
 * @author yukong
 * @date 2020/3/16 20:19
 */
public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trieTree = new Trie();
        for (String word : words) {
            trieTree.insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                find(board, trieTree, i, j, visited, ans);
            }
        }
        return new ArrayList<>(ans);
    }

    private void find(char[][] board, Trie cur, int i, int j, boolean[][] visited, Set<String> res) {
        //边界以及是否已经访问判断
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        Trie next = cur.childrens[board[i][j] - 'a'];
        visited[i][j] = true;
        if(next == null) {
            // 不匹配 回溯
            visited[i][j] = false;
            return;
        } else if (next.isLeaf == true) {
            res.add(next.item);
        }
        find(board, next, i + 1, j, visited, res);
        find(board, next, i - 1, j, visited, res);
        find(board, next, i, j + 1, visited, res);
        find(board, next, i, j - 1, visited, res);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] words= new char[1][2];
        words[0] = new char[]{'a', 'a'};

        String[] search = new String[] {"a"};
        System.out.println(new WordSearch2().findWords(words, search));
    }
}

