package com.xp.solutions._779_K_th_Symbol_in_Grammar;

/**
 * @author yukong 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * <p>
 * <p>
 * 例子:
 * <p>
 * 输入: N = 1, K = 1 输出: 0
 * <p>
 * 输入: N = 2, K = 1 输出: 0
 * <p>
 * 输入: N = 2, K = 2 输出: 1
 * <p>
 * 输入: N = 4, K = 5 输出: 1
 * <p>
 * 解释: 第一行: 0 第二行: 01 第三行: 0110 第四行: 01101001
 * <p>
 * 注意：
 * <p>
 * N 的范围 [1, 30]. K 的范围 [1, 2^(N-1)].
 * <p>
 * <p>
 * 思路： 如果直接计算字符串的长度最后会溢出，仔细寻找规律。即可发现
 * <p>
 * K 偶数 return self.kthGrammar(N - 1, K / 2) == 0 ? 1 : 0 K 奇数 return self.kthGrammar(N - 1, (K + 1)/ 2) == 0 ? 0 : 1
 */
public class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 0) {
            return 0;
        }
        if (K % 2 == 0) {
            return kthGrammar(N - 1, K / 2) == 0 ? 1 : 0;
        } else {
            return kthGrammar(N - 1, (K + 1) / 2) == 0 ? 0 : 1;
        }

    }

    /**
     * 来看这个例子，如果我们中间有一行是 "0110"，那么就会生成 "01101001" 作为它的下一行，也就是说第一位 "0" 生成下一行中的第一个 "01"，第二位 "1" 生成下一行中的 "10"，接着 "1" 又生成了
     * "10"，而最后的 "0" 将会生成最后的 "01"。 一般而言，第 K 位的父位应该是第 (K+1) / 2 位。如果父位是 0，那么这一位就是 1 - (K%2)。如果父位是 1，那么这一位就是 K%2。
     *
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar1(int N, int K) {
        if (K == 1) {
            return 0;
        }
        return ((K + 1) & 1) ^ kthGrammar(N - 1, (K + 1) / 2);
    }
}
