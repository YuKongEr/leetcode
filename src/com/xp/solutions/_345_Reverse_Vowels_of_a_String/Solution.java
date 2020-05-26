package com.xp.solutions._345_Reverse_Vowels_of_a_String;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yukong
 * @date 2020/5/26 21:52
 */
public class Solution {
    public String reverseVowels(String str) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('o');
        vowels.add('e');
        vowels.add('i');
        vowels.add('u');
        vowels.add('A');
        vowels.add('O');
        vowels.add('E');
        vowels.add('I');
        vowels.add('U');
        char[] s = str.toCharArray();
        int p = 0; int q = s.length - 1;
        while(p < q) {
            while(p < q && !vowels.contains(s[p])){
                p++;
            }
            while(q >= 0 && !vowels.contains(s[q])){
                q--;
            }
            if(p < q && vowels.contains(s[p]) && vowels.contains(s[q])) {
                char temp = s[q];
                s[q] = s[p];
                s[p] = temp;
                p++;
                q--;
            }
        }
        return new String(s);
    }

    public static void main(String[] args) {
        System.out.println(new  Solution().reverseVowels(".,"));
    }
}
