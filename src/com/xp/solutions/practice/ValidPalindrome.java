package com.xp.solutions.practice;

import javax.xml.stream.events.Characters;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama" 输出: true 示例 2:
 * <p>
 * 输入: "race a car" 输出: false
 *
 * @author yukong
 * @date 2020/3/11 15:34
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int p = 0, q = s.length() - 1;
        while (p < q) {
            while (!Character.isLetterOrDigit(s.charAt(p)) && p < q) {
                p++;
            }
            while (!Character.isLetterOrDigit(s.charAt(q)) && p < q) {
                q--;
            }
            if ( s.charAt(p++) == s.charAt(q--)) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println( new ValidPalindrome().isPalindrome("*."));
    }
}
