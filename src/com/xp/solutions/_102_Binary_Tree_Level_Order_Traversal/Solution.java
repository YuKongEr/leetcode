package com.xp.solutions._102_Binary_Tree_Level_Order_Traversal;

import com.xp.solutions.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yukong
 * @date 2020/5/13 16:52
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int i = 0;
        while(queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            while ( i++ < currentLevelSize) {
                TreeNode t = queue.removeLast();
                temp.add(t.val);
                if(t.left != null) {
                    queue.add(t.left);
                }
                if(t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(temp);
            i = 0;

        }
        return res;
    }



}
