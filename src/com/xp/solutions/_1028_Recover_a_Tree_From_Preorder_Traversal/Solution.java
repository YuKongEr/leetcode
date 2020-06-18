package com.xp.solutions._1028_Recover_a_Tree_From_Preorder_Traversal;

import com.xp.solutions.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author yukong
 * @date 2020/6/18 09:32
 */
public class Solution {
    int cur = 0, curD = 0;

    public TreeNode recoverFromPreorder(String S) {
        char[] nodes = S.toCharArray();
        return dfs(0, nodes);
    }

    public TreeNode dfs(int depth, char[] nodes) {
        int val = 0;
        for (; cur < nodes.length && nodes[cur] != '-'; cur++) {
            val = val * 10 + nodes[cur] - '0';
        }
        curD = 0;
        for (; cur < nodes.length && nodes[cur] == '-'; cur++, curD++) ;
        TreeNode r = new TreeNode(val);
        if (curD > depth) {
            r.left = dfs(curD, nodes);
        }
        if (curD > depth) {
            r.right = dfs(curD, nodes);
        }
        return r;
    }


    private TreeNode stackDfs(String s) {
        int idx = 0;
        Deque<TreeNode> path = new LinkedList<TreeNode>();
        while (idx < s.length()) {
            // 计算深度
            int level = 0;
            while (idx < s.length() && s.charAt(idx) == '-') {
                level++;
                idx++;
            }
            int val = 0;
            while (idx < s.length() && s.charAt(idx) != '-') {
                val = val * 10 + (s.charAt(idx) - '0');
                idx++;
            }
            TreeNode node = new TreeNode(val);
            if (path.size() == level) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (path.size() != level) {
                    path.pop();
                }
                if (!path.isEmpty()) {
                    path.peek().right = node;
                }
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.pop();
    }

    public static void main(String[] args) {
        new Solution().stackDfs("1-401--349---90--88");
    }
}
