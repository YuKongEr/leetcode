package com.xp.solutions._872_Leaf_Similar_Trees;

//请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
//
//
//
// 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
//
// 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
//
// 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
//
//
//
// 提示：
//
//
// 给定的两颗树可能会有 1 到 100 个结点。
//
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;

public class Solution {



	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		 ArrayList<Integer> list1 = new ArrayList<>();
		 ArrayList<Integer> list2 = new ArrayList<>();
		 dfs(root1, list1);
		 dfs(root2, list2);

		for (int i = 0; i < list1.size(); i++) {
			if(!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		return true;

	}

	private void dfs(TreeNode root, ArrayList arrayList) {
		if(root == null) {
			return ;
		}
		if(root.left == null && root.right == null) {
			arrayList.add(root.val);
		}
		dfs(root.left, arrayList);
		dfs(root.right, arrayList);
	}


}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
