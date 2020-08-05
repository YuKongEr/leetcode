package com.xp.solutions._337_House_Robber_III;

import com.xp.solutions.TreeNode;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/7 21:50
 */
public class Solution {
//    public int rob(TreeNode root) {
//        return dp(root);
//    }
//
//    private int dp(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(
//                // 不抢
//                dp(root.right) + dp(root.left),
//                // 抢
//                root.val + (root.right == null ? 0 : dp(root.right.left) + dp(root.right.right)) + (root.left == null ? 0 : dp(root.left.left) + dp(root.left.right))
//        );
//    }


    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
