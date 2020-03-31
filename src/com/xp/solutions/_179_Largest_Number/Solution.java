package com.xp.solutions._179_Largest_Number;

import java.util.Arrays;

/**
 * @author yukong
 * @date 2020/3/31 23:28
 * @description
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] newNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(newNums, (s1, s2) -> {
            String n1 = s1 + s2;
            String n2 = s2 + s1;
            return n2.compareTo(n1);
        });
        if("0".equals(newNums[0])) {
            return "0";
        }
        String res = "";
        for (String newNum : newNums) {
            res += newNum;
        }
        return res;
    }
}
