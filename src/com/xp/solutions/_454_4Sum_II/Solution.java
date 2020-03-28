package com.xp.solutions._454_4Sum_II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukong
 * @date 2020/3/28 19:52
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> valueCount = new HashMap<>();
        int res = 0;
        for (int i : A) {
            for (int j : B) {
                int count = i + j;
                valueCount.put(count, valueCount.getOrDefault(count, 0) + 1);
            }
        }
        for (int i : C) {
            for (int j : D) {
                int count = -(i + j);
                if (valueCount.containsKey(count)) {
                    res += valueCount.get(count);
                }
            }
        }
        return res;
    }
}
