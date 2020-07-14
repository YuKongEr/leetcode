package com.xp.solutions._40_Combination_Sum_II;

import java.util.*;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * @author yukong
 * @date 2020/7/14 14:06
 */
public class Solution {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, new LinkedList<Integer>(), target, 0);
        return new ArrayList<List<Integer>>(res);
    }

    private void backtracking(int[] candidates, LinkedList<Integer> choose, int target, int start) {
        // 找到目标值 添加进入结果集
        if (target == 0) {
            res.add(new ArrayList<Integer>(choose));
            return;
        }
        // 遍历可选择列表
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            // 小剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            choose.add(candidates[i]);
            backtracking(candidates, choose, target - candidates[i], i + 1);
            choose.removeLast();
        }
    }
}
