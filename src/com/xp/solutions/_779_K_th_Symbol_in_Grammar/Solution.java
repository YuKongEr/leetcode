package com.xp.solutions._779_K_th_Symbol_in_Grammar;

/**
 * @author yukong
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 *
 * 例子:
 *
 * 输入: N = 1, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 2
 * 输出: 1
 *
 * 输入: N = 4, K = 5
 * 输出: 1
 *
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 *
 * 注意：
 *
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 *
 *
 * 思路：
 * 如果直接计算字符串的长度最后会溢出，仔细寻找规律。即可发现
 *
 * K 偶数 return self.kthGrammar(N - 1, K / 2) == 0 ? 1 : 0
 * K 奇数 return self.kthGrammar(N - 1, (K + 1)/ 2) == 0 ? 0 : 1
 */
public class Solution {
    public int kthGrammar(int N, int K) {
        if(N == 0) {
            return 0;
        }
        if(K % 2 ==0) {
            return kthGrammar(N-1, K/2) == 0 ? 1: 0;
        } else {
            return kthGrammar(N-1, (K + 1)/2) == 0 ? 0: 1;
        }

    }
}
