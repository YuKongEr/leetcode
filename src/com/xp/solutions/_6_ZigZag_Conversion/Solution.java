package com.xp.solutions._6_ZigZag_Conversion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._6_ZigZag_Conversion
 * @Description:
 * @date 2018/1/18 13:43
 **/
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<StringBuilder>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int flag = -1;
        int rowIdx = 0;
        for (char c: s.toCharArray()) {
            list.get(rowIdx).append(c);
            if (rowIdx == 0 || rowIdx >= numRows - 1) {
                flag = - flag;
            }
            rowIdx += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder s1: list) {
            sb.append(s1.toString());

        }
        return sb.toString();
    }
}
