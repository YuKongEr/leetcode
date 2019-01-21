package com.xp.solutions._908_Smallest_Range_I;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * @author : yukong
 * @date : 2019-01-21 17:24
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 *
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 * 解题思路：
 *  题意为对数组A中每一个数加上一个范围在-2K到2K的数X, 求加上X后, 最大值和最小值的可能最小差值.
 *  假设原数组A最大值和最小值差值小于2K(可能填上的差值), 那么数组A中每一个数, 都可以加上恰当的X,
 *  使得各处相等, 此时可能最小差值为0 假设最大值和最小值的差值大于2K, 那么两者之间的差值无法填上, 可能的最小差值, 就是
 *
 * (最大值 - k) - (最小值 + k) = (最大值 - 最小值 - 2k)
 */
public class Solution {

    public int smallestRangeI(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int res = A[A.length - 1] - A[0] - 2 * K;
        return res <= 0 ? 0 : res;
    }

}
