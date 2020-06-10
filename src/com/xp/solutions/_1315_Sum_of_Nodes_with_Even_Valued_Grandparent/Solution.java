package com.xp.solutions._1315_Sum_of_Nodes_with_Even_Valued_Grandparent;

import com.xp.solutions.TreeNode;

/**
 * 1315. 祖父节点值为偶数的节点和 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。） 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *
 * @author yukong
 * @date 2020/6/10 11:23
 */
public class Solution {
    private int ans = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(null, null, root);
        return ans;
    }

    private void dfs(TreeNode grandparent, TreeNode parent, TreeNode node) {
        if (node == null) {
            return;
        }
        if (grandparent != null && (grandparent.val & 1) == 0) {
            ans += node.val;
        }
        dfs(parent, node, node.left);
        dfs(parent, node, node.right);
    }
}
