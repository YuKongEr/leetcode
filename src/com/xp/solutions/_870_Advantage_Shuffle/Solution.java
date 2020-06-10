package com.xp.solutions._870_Advantage_Shuffle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 870. 优势洗牌 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [2,7,11,15], B = [1,10,4,11] 输出：[2,11,7,15] 示例 2：
 * <p>
 * 输入：A = [12,24,8,32], B = [13,25,32,11] 输出：[24,32,8,12]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length = B.length <= 10000 0 <= A[i] <= 10^9 0 <= B[i] <= 10^9
 *
 * @author yukong
 * @date 2020/6/10 14:18
 */
public class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] res = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            res[i] = findVal(A, B[i]);
        }
        return res;
    }

    // 手写贪心
    private int findVal(int[] num, int target) {
        int res = Integer.MIN_VALUE;
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (target >= num[i]) {
                int tmp = 0;
                while (tmp < num.length && num[tmp] == Integer.MAX_VALUE) {
                    tmp++;
                }
                res = num[tmp];
                num[tmp] = Integer.MAX_VALUE;
                break;
            }
            if (num[i] > target) {
                int temp = i - 1;
                while (temp >= 0 && num[temp] == Integer.MAX_VALUE) {
                    temp--;
                }
                if (temp < 0 || num[temp] <= target) {
                    res = num[i];
                    num[i] = Integer.MAX_VALUE;
                    break;
                }
            }

        }
        return res;
    }



    // 贪心
    public int[] advantageCount1(int[] A, int[] B) {
       int[] numA = A.clone();
       int[] numB = B.clone();
       // assign
        Map<Integer, LinkedList<Integer>> assign = new HashMap<>();
        LinkedList<Integer> remain = new LinkedList<>();
        for (int i : B) {
            assign.put(i, new LinkedList<>());
        }
        Arrays.sort(numA);
        Arrays.sort(numB);
        int j = 0;
        for (int a : numA) {
            if(a > numB[j]) {
                assign.get(numB[j++]).add(a);
            } else {
                remain.add(a);
            }
        }
        // reconstruct
        for (int i = 0; i < B.length; i++) {
            if (assign.get(B[i]).size() > 0) {
                A[i] = assign.get(B[i]).pop();
            } else {
                A[i] = remain.pop();
            }

        }
        return A;
    }


    public static void main(String[] args) {
        // new Solution().advantageCount(new int[] {2,7,11,15}, new int[] {1,10,4,11});
        // new Solution().advantageCount(new int[] {12,24,8,32}, new int[] {13,25,32,11});
        new Solution().advantageCount(new int[]{0}, new int[]{0});
    }
}
