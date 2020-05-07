package com.xp.solutions._739_Daily_Temperatures;

import java.util.Stack;

/**
 * @author yukongcode@gmail.com
 * @date 2020/5/7 09:26
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        // 单调栈 维护一个单调递减的栈 时间复杂度O(n)
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i = T.length - 1; i >= 0; i--) {
            // 栈不为空 且栈顶的元素小于当前元素 出出出栈
            while(!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
