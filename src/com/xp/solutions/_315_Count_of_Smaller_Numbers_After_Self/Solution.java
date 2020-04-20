package com.xp.solutions._315_Count_of_Smaller_Numbers_After_Self;

import com.xp.solutions.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yukong
 * @date 2020/4/4 22:32
 */
public class Solution {
    public  List<Integer> countSmaller(int[] nums) {
        if (nums.length < 1) {
            return new ArrayList<Integer>();
        }
        Integer[] res = new Integer[nums.length];
        Arrays.fill(res, 0);
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = TreeNode.create(root, nums[i], i, res);
        }
        return Arrays.asList(res);
    }

    static class TreeNode {
        int val;
        int count;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


        public static TreeNode create(TreeNode root, int v, int i, Integer[] res) {
            if (root == null) {
                root = new TreeNode(v);
            } else if (v <= root.val) {
                root.count++;
                root.left = create(root.left, v, i, res);
            } else {
                res[i] += root.count + 1;
                root.right = create(root.right, v, i, res);
            }
            return root;
        }
    }

     
}
