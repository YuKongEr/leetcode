package com.xp.solutions._7_Reverse_Integer;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._7_Reverse_Integer
 * @Description: TODO
 * @date 2018/1/18 13:52
 **/
public class Solution {
    public int reverse(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) rev;
    }
}
