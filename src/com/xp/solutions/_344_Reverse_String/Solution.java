package com.xp.solutions._344_Reverse_String;

/**
 * 344. 反转字符串 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * @author yukong
 * @date 2020/3/19 20:45
 */
public class Solution {
    public void reverseString(char[] s) {
        int head = 0, tail = s.length -1;
        while (head < tail) {
            char ch = s[head];
            s[head] = s[tail];
            s[tail] = ch;
            head++;
            tail--;
        }
    }
}
