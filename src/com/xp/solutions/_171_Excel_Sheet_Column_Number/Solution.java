package com.xp.solutions._171_Excel_Sheet_Column_Number;

/**
 * @author yukongs
 * @date 2020/3/27 23:25
 */
public class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}
