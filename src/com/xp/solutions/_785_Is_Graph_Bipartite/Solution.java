package com.xp.solutions._785_Is_Graph_Bipartite;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yukong
 * @date 2020/7/16 20:41
 */
public class Solution {
    private int UNCOLOR = 0;
    private int RED = 1;
    private int GREEN = 2;

    boolean isBinary = true;
    int[] colors;

    /**
     * dfs / bfs 遍历 + 染色
     * 如果有一个节点重复被染色 则代表不是一个二分图
     *
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        colors = new int[graph.length];
        for (int i = 0; i < graph.length && isBinary; i++) {
            if (colors[i] == UNCOLOR) {
                dfs(graph, i, GREEN);
            }
        }
        return isBinary;
    }

    private void dfs(int[][] graph, int node, int color) {
        colors[node] = color;
        int colorRevert = color == RED ? GREEN : RED;
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == UNCOLOR) {
                dfs(graph, neighbor, colorRevert);
                if (!isBinary) {
                    return;
                }
            } else if (colors[neighbor] != colorRevert) {
                isBinary = false;
                return;
            }
        }
    }

    public boolean bfs(int[][] graph) {
        colors = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length && isBinary; i++) {
            // 如果没染色 入队
            if (colors[i] == UNCOLOR) {
                queue.offer(i);
                // 标记颜色
                colors[i] = GREEN;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int colorRevert = colors[node] == RED ? GREEN : RED;
                    for (int neighbor : graph[node]) {
                        // 没染色 则入队染色
                        if (colors[neighbor] == UNCOLOR) {
                            queue.offer(neighbor);
                            colors[neighbor] = colorRevert;
                        } else if (colors[neighbor] != colorRevert) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
