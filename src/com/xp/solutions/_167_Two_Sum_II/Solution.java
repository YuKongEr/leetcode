package com.xp.solutions._167_Two_Sum_II;

/**
 * @Auther: xiongping22369
 * @Date: 2018/8/2 19:49
 * @Description: 双指针解决
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        int[] result = new int[2];
        while (head < tail) {
            if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else if (numbers[head] + numbers[tail] < tail) {
                head++;
            } else {
                result[0] = numbers[head];
                result[1] = numbers[tail];
            }
        }
        return result;
    }

    public int[] twoSum1(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }

}
