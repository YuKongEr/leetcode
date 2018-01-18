package com.xp.solutions._8_String_to_Integer;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._8_String_to_Integer
 * @Description:
 * @date 2018/1/18 14:01
 **/
public class Solution {

    public static int myAtoi(String str) {
        //1、判空
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int i = 0;
        int sign = 1;
        int result = 0;

        //2、除去空格
        char empty = ' ';
        for (; str.charAt(i) == empty && i < str.length(); i++) {
            continue;
        }


        //3、 正负符号处理
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }

        //4、 计算
        while (i < str.length()) {

            int digit = str.charAt(i) - '0';

            if (digit < 0 || digit > 9) {
                break;
            }

            //5、 防止超出整形范围
            if (Integer.MAX_VALUE/10 < result || (Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE % 10  < digit) ) {
                return sign == 1 ? Integer.MAX_VALUE :  Integer.MIN_VALUE;
            }

            result = result  * 10+ digit;
            i++;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
}
