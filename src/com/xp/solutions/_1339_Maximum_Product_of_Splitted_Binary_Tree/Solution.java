package com.xp.solutions._1339_Maximum_Product_of_Splitted_Binary_Tree;

import com.xp.solutions.TreeNode;

/**
 * 1339. 分裂二叉树的最大乘积 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 * <p>
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6] 输出：110 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10） 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,null,null,5,6] 输出：90 解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6） 示例 3：
 * <p>
 * 输入：root = [2,3,9,10,7,8,6,5,4,11,1] 输出：1025 示例 4：
 * <p>
 * 输入：root = [1,1] 输出：
 *
 * @author yukong
 * @date 2020/6/25 14:03
 */
public class Solution {
    double sum = 0;
    double best = 0;

    public int maxProduct(TreeNode root) {
        sumDfs(root);
        bestDfs(root);
        return (int) ((best * (sum - best)) % (int) (1e9 + 7));
    }

    private void sumDfs(TreeNode root) {
        if (root == null) {
            return;
        }
        sum += root.val;
        sumDfs(root.left);
        sumDfs(root.right);
    }

    private double bestDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        double val = root.val + bestDfs(root.left) + bestDfs(root.right);
        if (Math.abs(2 * best - sum) > Math.abs(2 * val - sum)) {
            best = val;
        }
        return val;
    }
}
