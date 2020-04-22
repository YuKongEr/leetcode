package com.xp.solutions._149_Max_Points_on_a_Line;

import com.xp.solutions.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/22 10:34
 */
public class Solution {
    // bfs
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (size == 0) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    // dfs
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0 , res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth, res);
        dfs(root.left, depth, res);
    }
}
