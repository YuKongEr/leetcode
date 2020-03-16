package com.xp.solutions.practice;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple"); trie.search("apple");   // 返回 true trie.search("app");     // 返回 false trie.startsWith("app");
 * // 返回 true trie.insert("app"); trie.search("app");     // 返回 true 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。 保证所有输入均为非空字符串。
 *
 * @author yukong
 * @date 2020/3/15 21:20
 */
public class Trie {

    Trie[] childrens;
    String item;
    boolean isLeaf;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        childrens = new Trie[26];
        item = "";
        isLeaf = false;
    }

    public Trie(char ch) {
        childrens = new Trie[26];
        item = "";
        isLeaf = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            temp = temp.insert1(word.charAt(i));
        }
        temp.isLeaf = true;
        temp.item = word;
    }

    private Trie insert1(char value) {
        if (childrens[value - 'a'] == null) {
            childrens[value - 'a'] = new Trie(value);
        }
        return childrens[value - 'a'];
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(word, false);
    }

    private boolean search(String word, boolean isStartWith) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            temp = temp.search1(word.charAt(i));
            if (temp == null && i < word.length()) {
                return false;
            }
        }
        if (temp == null) {
            return false;
        }
        if (word.equals(temp.item)) {
            return true;
        }
        return isStartWith;

    }

    private Trie search1(char value) {
        return childrens[value - 'a'];
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return search(prefix, true);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("apple"));
    }
}
