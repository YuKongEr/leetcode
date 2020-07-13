package com.xp.solutions.practice;

import com.xp.solutions.ListNode;
import com.xp.solutions.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * @author yukong
 * @date 2020/7/13 20:34
 */
public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) {
            return new ListNode[1];
        }
        List<ListNode> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ListNode curr = null, head = null;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    head = curr = new ListNode(node.val);
                } else {
                    curr.next = new ListNode(node.val);
                    curr = curr.next;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(head);
        }
        return res.toArray(new ListNode[0]);
    }
}
