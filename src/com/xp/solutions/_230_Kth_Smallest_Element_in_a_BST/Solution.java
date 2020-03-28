package com.xp.solutions._230_Kth_Smallest_Element_in_a_BST;

import com.xp.solutions.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yukong
 * @date 2020/3/28 20:25
 */
public class Solution {

private int num = 0;
private int count = 0;

public int kthSmallest1(TreeNode root, int k) {
    inorder(root, k);
    return num;
}

private void inorder(TreeNode root, int k) {
    // 减枝
    if (root == null || count >= k) {
        return;
    }
    inorder(root.left, k);
    count++;
    if (k == count) {
        num = root.val;
    }
    inorder(root.right, k);
}

    public int kthSmallest2(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res.get(k - 1);
    }

    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return res;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
        return res;
    }


    public int kthSmallest3(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }

}
