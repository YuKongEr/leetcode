package com.xp.solutions._572_Subtree_of_Another_Tree;

import com.xp.solutions.TreeNode;

/**
 * @author yukongcode@gmail.com
 * @date 2020/5/7 13:28
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // t 为 null 一定都是 true
        if (t == null) {
            return true;
        }
        // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        if (s == null) {
            return false;
        }

        return isSameTree(s, t) || isSubtree(s.right, t) || isSubtree(s.left, t);
    }

    public  boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }

        if(s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
