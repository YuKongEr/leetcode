package com.xp.solutions._424_Longest_Repeating_Character_Replacement

/**
 *
 * @author yukong
 * @date 2020/3/9 15:40
 */
fun characterReplacement(s: String, k: Int): Int {
    var left = 0
    var right = 0
    var max = -1
    var result = 0
    val count = IntArray(26)
    while (left < s.length && right < s.length) {
        count[s[right] - 'A'] += 1
        max = Math.max(max, count[s[right] - 'A'])
        if (right - left + 1 - max > k) {
            count[s[left] - 'A'] = count[s[left] - 'A'] - 1
            left++
        }
        result = Math.max(result, right - left + 1)
        right++
    }
    return result
}