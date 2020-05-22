package com.xp.solutions._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import com.xp.solutions.TreeNode;

/**
 * @author yukong
 * @date 2020/5/22 15:31
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int pRootIndex = findRoot(inorder, is, ie, preorder[ps]);
        root.left = build(preorder, inorder, ps + 1, ps + pRootIndex - is, is, pRootIndex - 1);
        root.right = build(preorder, inorder, ps + pRootIndex - is + 1, pe, pRootIndex + 1, ie);
        return root;

    }

    private int findRoot(int[] inorder, int is, int ie, int root) {
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
