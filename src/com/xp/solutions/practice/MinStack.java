package com.xp.solutions.practice;

import java.util.Stack;

/**
 * @author yukong
 * @date 2020/3/20 09:22
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int num = stack.pop();
        if(num == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
