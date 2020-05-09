package com.xp.solutions._69_Sqrt_x;

/**
 * @author yukong
 * @date 2020/5/9 13:11
 */
public class Solution {
    // 二分法
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if((long)mid * mid <= x) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
