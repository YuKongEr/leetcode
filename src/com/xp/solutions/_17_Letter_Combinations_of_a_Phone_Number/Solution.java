package com.xp.solutions._17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._17_Letter_Combinations_of_a_Phone_Number
 * @Description: Letter Combinations of a Phone Number
 * @date 2018/1/26 17:12
 **/
public class Solution {

    public List<String> letterCombinations(String digits) {
        //把table上的数字对应的字母列出来，当输入为2是，digits[2]就是2所对应的"abc"
        String[] table = new String[]
                {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<String>();
        //index从0开始，即digits的第一个数字
        letterCombinations(list, digits, "", 0, table);
        return list;

    }

    private void letterCombinations(List<String> list, String digits, String currResult, int deep, String[] table) {
        if (deep == digits.length()) {
            if(currResult.length() != 0) {
                list.add(currResult);
            }
             return;
        }

        //找到数字对应的字符串
        String temp = table[digits.charAt(deep) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            //每次循环把不同字符串加到当前curr之后
            String next = currResult + temp.charAt(i);
            //进入下一层
            letterCombinations(list,digits,next,deep+1,table);
        }
    }


}


