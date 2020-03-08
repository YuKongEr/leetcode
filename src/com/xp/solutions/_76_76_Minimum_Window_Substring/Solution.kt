package com.xp.solutions._76_76_Minimum_Window_Substring

/**
 *
 * @author yukong
 * @date 2020/3/8 20:45
 */
fun main() {
    print(minWindow("AA", "AA"))
}

fun minWindow(s: String, t: String): String {
    val countMap = mutableMapOf<Char, Int>()
    val needMap = mutableMapOf<Char, Int>()
    t.forEach {
        needMap[it] = needMap.getOrDefault(it, 0) + 1
    }
    var left = 0
    var right = 0
    var match = 0
    var start = 0
    var minLength = Int.MAX_VALUE
    while (right < s.length) {
        var ch = s[right]
        if (needMap.containsKey(ch)) {
            countMap[ch] = countMap.getOrDefault(ch, 0) + 1
            if (countMap[ch] == needMap.getOrDefault(ch, 0)) {
                match++
            }
        }
        right++
        while (match == needMap.size) {
            if (right - left < minLength) {
                start = left
                minLength = right - left
            }
            ch = s[left++]
            if (needMap.containsKey(ch)) {
                countMap[ch] = countMap[ch]!! - 1
                if (countMap[ch]!! < needMap[ch]!!) {
                    match--
                }
            }
        }
    }
    return if(minLength == Int.MAX_VALUE)  "" else s.substring(start, start + minLength)
}