package com.xp.solutions._207_Course_Schedule;

import java.util.*;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/19 17:02
 */
public class Solution {
    // bfs
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if (numCourses <= 0) {
//            return true;
//        }
//        // 临接列表
//        List<List<Integer>> graph = new ArrayList<>(numCourses);
//        // 入度
//        int[] inDegree = new int[numCourses];
//        // 构造图
//        for (int i = 0; i < numCourses; i++) {
//            graph.add(new ArrayList<>());
//        }
//        for (int[] prerequisite : prerequisites) {
//            graph.get(prerequisite[1]).add(prerequisite[0]);
//            inDegree[prerequisite[0]]++;
//        }
//
//        // bfs队列
//        Queue<Integer> zeroQueue = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (inDegree[i] == 0) {
//                zeroQueue.offer(i);
//                // 标记已访问 以免bfs中重复访问
//                inDegree[i] = -1;
//            }
//        }
//        while (!zeroQueue.isEmpty()) {
//            int idx = zeroQueue.poll();
//            List<Integer> pointNode = graph.get(idx);
//            numCourses--;
//            pointNode.forEach(i -> {
//                inDegree[i]--;
//                if (inDegree[i] == 0) {
//                    zeroQueue.offer(i);
//                    inDegree[i] = -1;
//                }
//            });
//        }
//        return numCourses == 0;
//    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return true;
        }
        // 临接列表
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        // 访问状态
        int[] visited = new int[numCourses];
        // 构造图
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i, visited, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int curr, int[] visited, List<List<Integer>> graph) {
        if (visited[curr] == 1) {
            return false;
        }
        if (visited[curr] == -1) {
            return true;
        }
        visited[curr] = 1;
        for (int idx: graph.get(curr)) {
            if(!dfs(idx, visited, graph)) {
                return false;
            }
        }
        visited[curr] = -1;
        return true;
    }
}
