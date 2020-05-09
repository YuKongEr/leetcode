package com.xp.solutions._119_Pascal_s_Triangle_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yukong
 * @date 2020/5/9 13:49
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            //补上每层的最后一个 1
            cur.add(1);
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println( new Solution().getRow(3));
    }
}
