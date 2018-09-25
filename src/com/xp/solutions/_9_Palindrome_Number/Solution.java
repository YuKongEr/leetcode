package com.xp.solutions._9_Palindrome_Number;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._9_Palindrome_Number
 * @Description: TODO
 * @date 2018/1/18 14:28
 **/
public class Solution {

    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;

        }
        int div = 1;
        while(div<=x/10) {
            div *= 10;
        }
        while(x>0)
        {
            if(x/div!=x%10) {
                return false;
            }
            x = (x%div)/10;
            div /= 100;
        }
        return true;
    }

   /* public  boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        String num = String.valueOf(x);
        if (num.length() == 1) {
            return true;
        }
        int p = 0;
        int q = num.length() - 1;
        while ( p <= q) {
            if (num.charAt(p) == num.charAt(q)) {
                p++;
                q--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

 */


}
