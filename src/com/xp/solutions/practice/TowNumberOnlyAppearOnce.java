package com.xp.solutions.practice;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/28 14:24
 */
public class TowNumberOnlyAppearOnce {
    public int[] singleNumbers(int[] nums) {

        int res = 0;
        for (int n : nums) {
            res ^= n;
        }

        int mask = 1;
        while ((mask & res) == 0) {
            mask <<= 1;
        }


        int q = 0, p = 0;
        for (int n : nums) {
            if ((mask & n) == 0) {
                q ^= n;
            } else {
                p ^= n;
            }
        }
        return new int[]{p, q};

    }

    public static void main(String[] args) {
        new TowNumberOnlyAppearOnce().singleNumbers(new int[]{1,2,5,2});
    }
}
