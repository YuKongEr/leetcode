package com.xp.solutions._297_Serialize_and_Deserialize_Binary_Tree;

import com.xp.solutions.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yukong
 * @date 2020/6/16 21:46
 */
public class Solution {
    public String serialize(TreeNode root) {
        return levelOrder(root);
    }

    private String levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n != null) {
                queue.add(n.left);
                queue.add(n.right);
                sb.append(n.val);
            } else {
                sb.append("*");
            }
            sb.append(",");
        }
        return sb.delete(sb.length() - 1, sb.length()).toString();
    }

    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        TreeNode head = newNode(datas[i]);
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                continue;
            }
            // 左树
            int j = ++i;
            if (j >= datas.length) {
                break;
            }
            curr.left = newNode(datas[j]);
            queue.add(curr.left);
            j = ++i;
            if (j >= datas.length) {
                break;
            }
            curr.right = newNode(datas[j]);
            queue.add(curr.right);

        }
        return head;
    }

    private TreeNode newNode(String val) {
        if ("*".equals(val)) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));

    }

}
