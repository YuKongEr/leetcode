package com.xp.solutions._12_Integer_to_Roman;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._12_Integer_to_Roman
 * @Description: TODO
 * @date 2018/1/22 15:28
 **/
public class Solution {

    public String intToRoman(int num) {

        char romans[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int values[] = {1000, 500, 100, 50, 10, 5, 1};
        StringBuffer res = new StringBuffer("");
        for (int i = 0; i < 7; i+=2) {
            int temp = num/values[i];
            if ( temp < 4) {
                for (int j = 1; j <= temp; j++) {
                    res.append(romans[i]);
                }
            } else if (temp == 4) {
                res.append(romans[i]).append(romans[i-1]);
            } else if (temp > 4 && temp < 9) {
                res.append(romans[i-1]);
                for (int j = 6; j <= temp ; j++) {
                    res.append(romans[i]);
                }
            } else if (temp == 9) {
                res.append(romans[i]).append(romans[i-2]);
            }
            num = num % values[i];
        }
        return res.toString();

    }

}
