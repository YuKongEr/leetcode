package com.xp.solutions._114_Flatten_Binary_Tree_to_Linked_List;

import com.xp.solutions.TreeNode;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * <p>
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 *
 * @author yukong
 * @date 2020/8/2 09:34
 */
public class Solution {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = null;
        TreeNode right = root.right;
        if (left != null) {
            root.right = dfs(left);
        }
        TreeNode curr = root;
        if (right != null) {
            while(curr.right != null) {
                curr = curr.right;
            }
            curr.right = dfs(right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        right.right = new TreeNode(6);

        root.left = left;
        root.right = right;

        new Solution().flatten(root);
        System.out.println(root);
    }
}
