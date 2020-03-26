package com.xp.solutions._150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"] 输出: 9 解释: ((2 + 1) * 3) = 9 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"] 输出: 6 解释: (4 + (13 / 5)) = 6 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"] 输出: 22 解释: ((10 * (6 / ((9 + 3) * -11))) +
 * 17) + 5 = ((10 * (6 / (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 = (0 + 17) + 5 = 17
 * + 5 = 22
 *
 * @author yukong
 * @date 2020/3/25 21:32
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<Integer>();
        int op1, op2;
        for(String s : tokens) {
            switch (s) {
                case "+":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 + op2);
                    break;
                case "-":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 - op2);
                    break;
                case "*":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 * op2);
                    break;
                case "/":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 / op2);
                    break;
                default:
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        return numStack.pop();
    }
}
