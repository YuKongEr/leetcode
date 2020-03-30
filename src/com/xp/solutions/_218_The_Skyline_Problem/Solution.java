package com.xp.solutions._218_The_Skyline_Problem;

import javafx.util.Pair;

import java.util.*;

/**
 * @author yukong
 * @date 2020/3/30 21:22
 * @description
 */
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if(buildings.length == 0) {
            return new ArrayList<>();
        }
        return getSkyLine(buildings, 0, buildings.length  - 1);
    }

    private List<List<Integer>> getSkyLine(int[][] buildings, int start, int end) {
        List<List<Integer>> res = new ArrayList<>();
        // 结束条件
        if (start == end) {
            res.add(Arrays.asList(buildings[start][0], buildings[start][2]));
            res.add(Arrays.asList(buildings[start][1], 0));
            return res;
        }
        int mid = start + (end - start) / 2;
        List<List<Integer>> lSkyLine = getSkyLine(buildings, start, mid);
        List<List<Integer>> rSkyLine = getSkyLine(buildings, mid + 1, end);
        return mergeSkyLine(lSkyLine, rSkyLine);
    }

    private List<List<Integer>> mergeSkyLine(List<List<Integer>> lSkyLine, List<List<Integer>> rSkyLine) {
        List<List<Integer>> res = new ArrayList<>();
        long xIndex = 0;
        int i = 0, j = 0;
        long x1 = 0, x2 = 0;
        int h1 = 0, h2 = 0;
        int height = 0;
        while (i < lSkyLine.size() || j < rSkyLine.size()) {
             x1 = i < lSkyLine.size() ? lSkyLine.get(i).get(0) : Long.MAX_VALUE;
             x2 = j < rSkyLine.size() ? rSkyLine.get(j).get(0): Long.MAX_VALUE;
             // 比较横坐标
            if(x1 < x2) {
                xIndex = x1;
                h1 = lSkyLine.get(i).get(1);
                i++;
            } else if(x2 < x1) {
                xIndex = x2;
                h2 = rSkyLine.get(j).get(1);
                j++;
            } else {
                xIndex = x1;
                h1 = lSkyLine.get(i).get(1);
                h2 = rSkyLine.get(j).get(1);
                i++;
                j++;
            }
            height = Math.max(h1, h2);
            // res里面最后一个不等于height才加入
            if(res.size() == 0 || res.get(res.size() - 1).get(1) != height) {
                res.add(Arrays.asList((int)xIndex, height));
            }
        }
        return res;
    }

    public List<List<Integer>> getSkyline1(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if(buildings.length == 0) {
            return res;
        }
        List<List<Integer>> points = new ArrayList<>();
        for(int[] line: buildings) {
            points.add(Arrays.asList(line[0], -line[2]));
            points.add(Arrays.asList(line[1], line[2]));
        }
        points.sort((p1, p2) -> {
            if (!p1.get(0).equals(p2.get(0))) {
                return p1.get(0) - p2.get(0);
            } else {
                return p1.get(1) - p2.get(1);
            }
        });
        Queue<Integer> queue = new PriorityQueue<>((p, q) -> {
            return q - p;
        });
        queue.add(0);
        int preMax = 0;
        for(List<Integer> point: points) {
            int x = point.get(0);
            int y = point.get(1);
            //左上角坐标
            if (y < 0) {
                queue.offer(-y);
                //右上角坐标
            } else {
                queue.remove(y);
            }
            int curMax = queue.peek();
            //最大值更新了, 将当前结果加入
            if (curMax != preMax) {
                res.add(Arrays.asList(x, curMax));
                preMax = curMax;
            }
        }
        return getSkyLine(buildings, 0, buildings.length  - 1);
    }

    public static void main(String[] args) {
        int[][] line = new int[][]{{0, 2, 3},{2, 5, 3}};
        new Solution().getSkyline(line);
    }
}
