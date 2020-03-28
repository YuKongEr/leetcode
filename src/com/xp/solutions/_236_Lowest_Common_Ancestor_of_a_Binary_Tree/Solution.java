package com.xp.solutions._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import com.xp.solutions.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * @author yukong
 * @date 2020/3/28 21:30
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return postOrder(root, p ,q);
    }

    public TreeNode postOrder(TreeNode root, TreeNode p, TreeNode q) {
        // 1、root == null 说明找到底了 没找到返回null
        // 2、root = p || root = q 说明当前节点的就是q或者p 返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 后续遍历 先从子树找如果子树找不到 根据题意一定存在最低公共祖先所以返回root
        TreeNode left = postOrder(root.left, p, q);
        TreeNode right = postOrder(root.right, p, q);
        // 如果左子树没有找到 那么根据题意一定在右子树
        if(left == null) {
            return right;
        }
        // 如果右子树没有找到 那么根据题意一定在左子树
        if(right == null) {
            return left;
        }
        // 如果左子树 右子树都有 那么root就是最低公共祖先节点
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        parentMap.put(root, null);
        nodeStack.push(root);
        //将遍历过程中每个节点的父节点保存起来
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = nodeStack.pop();
            if(node.left != null) {
                nodeStack.push(node.left);
                parentMap.put(node.left, node);
            }
            if(node.right != null) {
                nodeStack.push(node.right);
                parentMap.put(node.right, node);
            }
        }
        HashSet<TreeNode> path = new HashSet<>();
        // 记录p节点从尾到头的路径
        while (p != null) {
            path.add(p);
            p = parentMap.get(p);
        }
        // 遍历q节点从头到位的路径 并且找出第一个公共的节点
        while (q != null) {
            if(path.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return q;
    }

}
