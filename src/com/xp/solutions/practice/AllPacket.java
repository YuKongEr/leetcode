package com.xp.solutions.practice;

/**
 * @author yukong
 * @date 2020/8/5 17:02
 */
public class AllPacket {


    public  static int pricesMax() {
        int m = 10, n = 3;
        int[] v = new int[]{0, 2, 1, 3};
        int[] w = new int[]{0, 1, 2, 3};
        int[] num = new int[]{0, 10, 3, 5};
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k * v[i] <= j && k <= num[i ]; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        System.out.println(pricesMax());
    }
}
