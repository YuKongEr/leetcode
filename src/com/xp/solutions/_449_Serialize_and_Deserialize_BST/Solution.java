package com.xp.solutions._449_Serialize_and_Deserialize_BST;

import com.xp.solutions.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author yukong
 * @date 2020/3/28 22:22
 */
public class Solution {
//    public String serialize(TreeNode root) {
//        StringBuilder sb = new StringBuilder();
//        preorder(root, sb);
//        return sb.delete(sb.length() - 1, sb.length()).toString();
//    }
//
//    public StringBuilder preorder(TreeNode root, StringBuilder sb) {
//        if (root == null) {
//            return sb;
//        }
//        sb.append(root.val);
//        sb.append(' ');
//        preorder(root.left, sb);
//        preorder(root.right, sb);
//        return sb;
//    }


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
            if(curr == null) {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode ll = new TreeNode(2);
        root.left = left;
        root.right = right;
        left.right = ll;
        String s = new Solution().serialize(root);
        System.out.println(s);
        System.out.println(root.val);
        new Solution().deserialize("5,2,3,*,*,2,4,3,1");
    }
}
