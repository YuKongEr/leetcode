package com.xp.solutions._39_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 * @author yukong
 * @date 2020/7/14 13:21
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序是为了提前终止搜索
        Arrays.sort(candidates);
        backtrack(candidates, new LinkedList<Integer>(), target, 0);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param candidates 待选择列表
     * @param choose     以选择列表
     * @param target     目标值
     * @param start      待选择列表起始索引
     */
    private void backtrack(int[] candidates, LinkedList<Integer> choose, int target, int start) {
        // 满足条件 加入结果集
        if (target == 0) {
            res.add(new ArrayList<Integer>(choose));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            choose.add(candidates[i]);
            backtrack(candidates, choose, target - candidates[i], i);
            choose.removeLast();
        }
    }
}
