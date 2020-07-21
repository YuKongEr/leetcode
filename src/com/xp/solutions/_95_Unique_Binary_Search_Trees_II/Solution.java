package com.xp.solutions._95_Unique_Binary_Search_Trees_II;

import com.xp.solutions.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @author yukong
 * @date 2020/7/21 21:29
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0) {
            return ans;
        }
        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        // 边界条件
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <= end; i++) {
            // 拿到start 到 i-1的所有左子树可能结果
            List<TreeNode> lefts = generateTree(start, i - 1);
            // 拿到 i + 1 到 end 的所有右子树可能结果
            List<TreeNode> rights = generateTree(i + 1, end);
            //交叉乘积
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
