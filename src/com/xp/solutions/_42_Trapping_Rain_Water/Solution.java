package com.xp.solutions._42_Trapping_Rain_Water;

import java.util.Stack;

/**
 * <a>https://leetcode-cn.com/problems/trapping-rain-water/</a>
 * 42. 接雨水 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1] 输出: 6
 *
 * @author yukong
 * @date 2020/6/11 14:25
 */
public class Solution {

    // 备忘录法
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int n = height.length;
        // 左边的最大值
        int[] leftMax = new int[n];
        // 右边的最大值
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    // 双指针
    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left++];
            } else {
                ans += rightMax - height[right--];
            }
        }
        return ans;
    }

    // 单调栈
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int n = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < n;  i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int current = stack.pop();
                // 跳过值相等的
                while(!stack.isEmpty() && height[stack.peek()] == height[current]) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    int biger = stack.peek();
                    ans += (Math.min(height[biger], height[i]) - height[current]) * (i - biger - 1);
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
