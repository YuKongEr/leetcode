package com.xp.solutions._337_House_Robber_III;

import com.xp.solutions.TreeNode;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/7 21:50
 */
public class Solution {
    public int rob(TreeNode root) {
        return dp(root);
    }

    private int dp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(
                // 不抢
                dp(root.right) + dp(root.left),
                // 抢
                root.val + (root.right == null ? 0 : dp(root.right.left) + dp(root.right.right)) + (root.left == null ? 0 : dp(root.left.left) + dp(root.left.right))
        );
    }
}
