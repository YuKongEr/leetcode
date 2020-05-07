package com.xp.solutions._402_Remove_K_Digits;

import java.util.LinkedList;

/**
 * @author yukongcode@gmail.com
 * @date 2020/5/7 13:24
 */
public class Solution {
    // 单调栈
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i = 0; i < num.toCharArray().length; i++) {
            while(k > 0 && !stack.isEmpty() && stack.getLast() >  num.charAt(i)) {
                stack.removeLast();
                k--;
            }
            stack.addLast( num.charAt(i));
        }
        for(int i=0; i < k; ++i) {
            stack.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean beginIsZero = true;
        for(Character c : stack) {
            if(beginIsZero && c == '0') {
                continue;
            }
            beginIsZero = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
