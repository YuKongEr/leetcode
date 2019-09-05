package com.xp.solutions._680_Valid_Palindrome_II;

/**
 * @author yukong
 * @date 2019-05-13 11:08
 */
public class Solution {

    public boolean validPalindrome(String s) {
        int start = -1;
        int end = s.length();
        while (++start < --end) {
            if(s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, Integer start, Integer end) {
        while (start < end) {
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

}
