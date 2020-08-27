package com.xp.solutions._332_Reconstruct_Itinerary;

import java.util.*;

/**
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * <p>
 * 说明:
 * <p>
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 * <p>
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 * <p>
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 *
 * @author yukong
 * @date 2020/8/27 14:43
 */
public class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> trace = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        tickets.forEach(t ->
                graph.computeIfAbsent(t.get(0), e -> new PriorityQueue<>()).add(t.get(1))
        );
        dfs("JFK");
        Collections.reverse(trace);
        return trace;
    }

    private void dfs(String t) {
        PriorityQueue<String> queue = graph.get(t);
        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll());
        }
        trace.add(t);
    }
}
