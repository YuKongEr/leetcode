package com.xp.solutions._974_Subarray_Sums_Divisible_by_K;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukong
 * @date 2020/5/27 21:42
 */
public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int N = A.length, sum = 0, ans = 0;
        int[] map = new int[K];
        map[0] = 1;
        for (int i = 1; i <= N; i++) {
            sum = sum + A[i-1];
            int key = (sum % K + K) % K;
            ans += map[key];
            map[key]++;
        }
        return ans;
    }


}
