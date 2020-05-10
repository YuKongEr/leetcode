package com.xp.solutions._50_Pown_x_n;

/**
 * @author yukong
 * @date 2020/5/10 10:16
 */
public class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return myPow1(x, N);
    }

    private double myPow1(double x, long n){

        if(n == 1){
            return x;
        }
        double half =  myPow1(x, n / 2);
        if(n % 2 == 0){
            return half * half;
        }
        return  half * half * x;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().myPow(0.00001, 2147483647));
    }
}
