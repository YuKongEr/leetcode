package com.xp.solutions._264_Ugly_Number_II;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/26 13:30
 */
public class Solution {

    class Ugly {
        int[] ugs;

        public Ugly(int n) {
            this.ugs = new int[n];
            ugs[0] = 1;
            int i2 = 0, i3 = 0, i5 = 0;
            for (int i = 1; i < n; i++) {
                int val = Math.min(ugs[i2] * 2, Math.min(ugs[i3] * 3, ugs[i5] * 5));
                ugs[i] = val;
                if (ugs[i2] * 2 == val) {
                    ++i2;
                }
                if (ugs[i3] * 3 == val) {
                    ++i3;
                }
                if (ugs[i5] * 5 == val) {
                    ++i5;
                }
            }
        }
    }

    public int nthUglyNumber(int n) {
        return new Ugly(n).ugs[n - 1];
    }
}
