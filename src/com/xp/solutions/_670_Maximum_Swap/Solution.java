package com.xp.solutions._670_Maximum_Swap;

import java.util.Arrays;

/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 *
 * @author yukong
 * @date 2020/7/28 14:56
 */
public class Solution {
    public int maximumSwap(int num) {
        //1.排序数组元素
        char[] orderNum = Integer.toString(num).toCharArray();
        char[] oldNum = Integer.toString(num).toCharArray();
        Arrays.sort(orderNum);//这里是从小到大排列

        int diff = -1;
        //2.比较第一个不同的元素
        for (int i = 0; i < orderNum.length; i++) {
            if (oldNum[i] != orderNum[orderNum.length - 1 - i]) {
                diff = i;
                break;
            }
        }

        //两数相同，不需要交换
        if (diff == -1) return num;

        //两两交换
        for (int i = oldNum.length - 1; i >= diff; i--) {
            if (oldNum[i] == orderNum[orderNum.length - 1 - diff]) {
                //交换后直接跳出
                swap(oldNum, diff, i);
                break;
            }
        }

        return Integer.parseInt(new String(oldNum));
    }

    private void swap(char[] chars, int lo, int hi) {
        char tmp = chars[lo];
        chars[lo] = chars[hi];
        chars[hi] = tmp;

    }
}
