package com.xp.solutions._3_Longest_Substring_Without_Repeating_Characters

import kotlin.math.max

/**
 *
 * 滑动窗口问题
 * 分为双指针 left right
 * right指针向前移动保证当前子串是不重复的
 * 如 遇到重复字符串(通过hashmap判断当前字符是否重复出现)
 * 则left向前移动直至 当前子串没有重复字符(right -left)
 * 记录途中的(right -left) 其中最大的就是最长不重复子串长度
 * @author yukong
 * @date 2020/3/8 20:12
 */
fun main() {
    println(lengthOfLongestSubstring("pwwkew"))
}

fun lengthOfLongestSubstring(s: String): Int {
    var left = 0
    var right = 0
    val indexMap = mutableMapOf<Char, Int>()
    var maxLength = 0
    while (left < s.length && right < s.length) {
        val ch = s[right]
        var count = indexMap.getOrDefault(ch, 0)
        indexMap[ch] = ++count
        right++
        while (indexMap[ch]!! > 1) {
            val newCh = s[left]
            count = indexMap.getOrDefault(newCh, 0)
            indexMap[s[left++]] = --count
        }
        maxLength = max(maxLength, right - left)
    }
    return maxLength
}