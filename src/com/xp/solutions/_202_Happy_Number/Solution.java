package com.xp.solutions._202_Happy_Number;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/30 09:28
 */
public class Solution {
    private int getNext(int n) {
        int sum = 0;
        int d = 0;
        while( n > 0) {
            d = n % 10;
            n /= 10;
            sum += d * d;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while(slow != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext( getNext(fast));
        }
        return fast == 1;
    }
}
