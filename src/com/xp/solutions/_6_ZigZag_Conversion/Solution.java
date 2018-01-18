package com.xp.solutions._6_ZigZag_Conversion;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._6_ZigZag_Conversion
 * @Description:
 * @date 2018/1/18 13:43
 **/
public class Solution {
    public String convert(String s, int nRows) {
        if(s == null || s.length()==0 || nRows <=0) {
            return "";
        }
        if(nRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int size = 2*nRows-2;
        for(int i=0;i<nRows;i++)
        {
            for(int j=i;j<s.length();j+=size)
            {
                res.append(s.charAt(j));
                if(i!=0 && i!=nRows-1 && j+size-2*i<s.length()) {
                    res.append(s.charAt(j+size-2*i));
                }
            }
        }
        return res.toString();
    }
}
