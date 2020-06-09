package com.xp.solutions.practice;

import java.util.Arrays;

/**
 * @author yukong
 * @date 2020/6/9 18:26
 */
public class LCOF {

    private int[] mem;

    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        mem = new int[n + 1];
        Arrays.fill(mem, -1);
        mem[n - 1] = 1;
        mem[n] = 1;
        return dfs(0, numStr);
    }

    // dfs + memo
    private int dfs(int pointer, String num) {
        if (mem[pointer] != -1) {
            return mem[pointer];
        }
        int temp = Integer.parseInt(num.substring(pointer, pointer + 2));
        if (temp >= 10 && temp <= 25) {
            mem[pointer] = dfs(pointer + 1, num) + dfs(pointer + 2, num);
        } else {
            mem[pointer] = dfs(pointer + 1, num);
        }
        return mem[pointer];
    }

    // dp
    private int dp(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int temp = Integer.parseInt(numStr.substring(i - 2, i));
            if (temp >= 10 && temp <= 25) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new LCOF().translateNum(25));
    }
}
