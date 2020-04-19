package com.xp.solutions._210_Course_Schedule_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/19 17:32
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] temp: prerequisites) {
            graph.get(temp[1]).add(temp[0]);
            inDegree[temp[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses ; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
                inDegree[i]--;
            }
        }
        int[] res = new int[numCourses];
        int index = 0;

        // bfs 遍历
        while (!queue.isEmpty()) {
            int point = queue.poll();
            res[index++] = point;
            numCourses--;
            for(int next: graph.get(point)) {
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    queue.offer(next);
                    inDegree[next]--;
                }
            }
        }
        if(numCourses == 0) {
            return res;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        new Solution().findOrder(2 , new int[][]{{1,0}});
    }
}
