package com.xp.solutions._633_Sum_of_Square_Numbers;

/**
 * @Auther: xiongping22369
 * @Date: 2018/8/2 20:00
 * @Description: 双指针
 */
public class Solution {

    public boolean judgeSquareSum(int c) {
        int min = 0;
        int max = (int) Math.sqrt(c);
        while(min < max) {
            int num = min * min + max * max;
            if (num == c) {
                return true;
            } else if (num > c) {
                max--;
            } else {
                min++;
            }
        }
        return false;
    }

}
