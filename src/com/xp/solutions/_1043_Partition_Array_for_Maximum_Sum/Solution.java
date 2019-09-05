package com.xp.solutions._1043_Partition_Array_for_Maximum_Sum;
//给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。
//
// 返回给定数组完成分隔后的最大和。
//
//
//
// 示例：
//
// 输入：A = [1,15,7,9,2,5,10], K = 3
//输出：84
//解释：A 变为 [15,15,15,9,10,10,10]
//
//
//
// 提示：
//
//
// 1 <= K <= A.length <= 500
// 0 <= A[i] <= 10^6
//
// Related Topics 图

import java.util.regex.Matcher;

/**
 * @author yukong
 * @date 2019-09-05 18:44
 */
public class Solution {





		public int maxSumAfterPartitioning(int[] array, int k) {

			int[] res = new int[array.length];

			for (int i = 0; i < array.length; i++) {
				int max = array[i];
				// dp
				for (int j = 1; j <= k && i - j + 1 >=0; j++) {
					max = Math.max(max, array[i -j + 1]);
					if (i - j >= 0) {
						res[i] = Math.max(res[i], res[i-j] + j*max);
					} else {
						res[i] = Math.max(res[i], j*max);
					}
				}
			}

			return res[array.length - 1];
		}


}
