package com.xp.solutions._12_Roman_to_Integer;

import java.util.HashMap;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._12_Integer_to_Roman
 * @Description: TODO
 * @date 2018/1/22 15:28
 **/
public class Solution {

    public static int romanToInt(String roman) {

        int res = 0;

        HashMap<String,Integer> map = new HashMap<>(7);
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V",5);
        map.put("I", 1);
        for (int i = 0; i < roman.length(); i++) {
            int val = map.get(String.valueOf(roman.charAt(i)));
            if (i == roman.length() - 1 || val >= map.get(String.valueOf((roman.charAt(i+1))))){
                res += val;
            } else {
                res -= val;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCVI"));
    }

}
