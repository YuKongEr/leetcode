package com.xp.solutions.practice

/**
 *
 * @author yukong
 * @date 2019-09-26 17:06
 *
 *  求众数
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

 */
internal class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        var m = 0
        var n = 0
        for (i in nums.indices) {
            if (nums[i] == m) {
                n++
            } else {
                if (n == 0) {
                    m = nums[i]
                    n++
                } else {
                    n--
                }
            }
        }
        return m
    }
}