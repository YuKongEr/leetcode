package com.xp.solutions._84_Largest_Rectangle_in_Histogram;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 输入: [2,1,5,6,2,3] 输出: 10
 *
 * @author yukong
 * @date 2020/6/20 11:02
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int len = heights.length;
        int[] newHeight = new int[len + 2];
        System.arraycopy(heights, 0, newHeight, 1, len);
        newHeight[0] = 0;
        newHeight[len + 1] = 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                int curr = stack.pop();
                int left = stack.peek() + 1;
                int right = i - 1;
                ans = Math.max(ans, (right - left + 1) * newHeight[curr]);
            }
            stack.push(i);
        }
        return ans;
    }
}
