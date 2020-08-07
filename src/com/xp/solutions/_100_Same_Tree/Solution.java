package com.xp.solutions._100_Same_Tree;

import com.xp.solutions.TreeNode;

/**
 * @author yukong
 * @date 2020/8/7 17:16
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
