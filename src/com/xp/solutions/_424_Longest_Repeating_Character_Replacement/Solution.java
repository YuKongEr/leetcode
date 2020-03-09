package com.xp.solutions._424_Longest_Repeating_Character_Replacement;

/**
 * @author yukong
 * @date 2020/3/9 14:20
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAA", 0));

    }

    public static int characterReplacement(String s, int k) {
        int left = 0, right = 0, max = -1, result = 0;
        int[] count = new int[26];
        while (left < s.length() && right < s.length()) {
            count[s.charAt(right) - 'A'] += 1;
            max = Math.max(max, count[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k) {
                count[s.charAt(left) - 'A'] = count[s.charAt(left) - 'A'] - 1;
                left++;

            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
