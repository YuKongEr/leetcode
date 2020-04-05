package com.xp.solutions._124_Binary_Tree_Maximum_Path_Sum;

        import com.xp.solutions.TreeNode;

        import java.util.LinkedList;
        import java.util.Queue;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/5 21:34
 */
public class Solution {
    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int res = getMaxPath(root);

        return Math.max(res, maxValue);
    }

    public int getMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = Math.max(getMaxPath(root.left), 0);
        int rightValue = Math.max(getMaxPath(root.right), 0);
        int res = leftValue + rightValue + root.val;
        maxValue = Math.max(maxValue, res);
        return root.val + Math.max(leftValue, rightValue);
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
        if ("null".equals(val)) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));

    }

    public static void main(String[] args) {
        TreeNode root = new Solution().deserialize("5,4,8,11,null,13,4,7,2,null,null,null,1");
        int res = new Solution().maxPathSum(root);
        System.out.println(res);
    }
}
