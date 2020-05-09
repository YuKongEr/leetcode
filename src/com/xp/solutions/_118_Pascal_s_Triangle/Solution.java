package com.xp.solutions._118_Pascal_s_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yukong
 * @date 2020/5/9 13:36
 */
public class Solution {
    private int[][] mem;
    // 递归
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        mem  = new int[numRows][numRows];
        for(int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                temp.add(generateValue(i, j));
            }
            res.add(temp);
        }
        return res;
    }

    private int generateValue(int i, int j) {
        if(mem[i][j] != 0) {
            return mem[i][j];
        }
        if( i == j || j == 0) {
            return 1;
        }
        mem[i][j] =  generateValue(i-1, j-1) + generateValue(i - 1, j);
        return mem[i][j];
    }
}
