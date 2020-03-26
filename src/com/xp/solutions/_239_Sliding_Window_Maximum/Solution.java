package com.xp.solutions._239_Sliding_Window_Maximum;

import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7] 解释:
 * <p>
 * 滑动窗口的位置                最大值 ---------------               ----- [1  3  -1] -3  5  3  6  7       3 1 [3  -1  -3] 5  3 6
 * 7       3 1  3 [-1  -3  5] 3  6  7       5 1  3  -1 [-3  5  3] 6  7       5 1  3  -1  -3 [5  3  6] 7       6
 *
 * @author yukong
 * @date 2020/3/24 22:12
 */
public class Solution {

    /**
     * 解法一 、动态规划 直觉
     * <p>
     * 这是另一个 {O}(N)O(N) 的算法。本算法的优点是不需要使用 数组 / 列表 之外的任何数据结构。
     * <p>
     * 算法的思想是将输入数组分割成有 k 个元素的块。 若 n % k != 0，则最后一块的元素个数可能更少。
     * <p>
     * <p>
     * <p>
     * 开头元素为 i ，结尾元素为 j 的当前滑动窗口可能在一个块内，也可能在两个块中。
     * <p>
     * <p>
     * <p>
     * 情况 1 比较简单。 建立数组 left， 其中 left[j] 是从块的开始到下标 j 最大的元素，方向 左->右。
     * <p>
     * <p>
     * <p>
     * 为了处理更复杂的情况 2，我们需要数组 right，其中 right[j] 是从块的结尾到下标 j 最大的元素，方向 右->左。right 数组和 left 除了方向不同以外基本一致。
     * <p>
     * <p>
     * <p>
     * 两数组一起可以提供两个块内元素的全部信息。考虑从下标 i 到下标 j的滑动窗口。 根据定义，right[i] 是左侧块内的最大元素， left[j] 是右侧块内的最大元素。因此滑动窗口中的最大元素为 max
     * (right[i], left[j])。
     * <p>
     * <p>
     * <p>
     * 算法
     * <p>
     * 算法十分直截了当：
     * <p>
     * 从左到右遍历数组，建立数组 left。
     * <p>
     * 从右到左遍历数组，建立数组 right。
     * <p>
     * 建立输出数组 max(right[i], left[i + k - 1])，其中 i 取值范围为 (0, n - k + 1)。
     * <p>
     * 实现
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            // 从左到右分块 如果是块开头的元素
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            // 从右到左分块  如果是块开头的元素
            int j = n - 1 - i;
            if (j + 1 % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }

        return output;

    }

    /**
     * 用双向队列来实现一个单调队列
     */
    private LinkedList<Integer> queue;
    private int[] array;

    public void push(int n) {
        // 队列不为空 && 且删除队尾比当前push小的数
        while (!queue.isEmpty() && array[queue.peekLast()] < array[n]) {
            queue.removeLast();
        }
        queue.addLast(n);
    }

    /**
     * 出队列
     * @param n
     */
    public void pop(int n) {
        if (!queue.isEmpty() && queue.peekFirst() == n) {
            queue.removeFirst();
        }
    }

    public int max() {
        return array[queue.peekFirst()];
    }




    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        queue = new LinkedList<>();
        array = nums;
        int[] res = new int[n + 1 - k];
        for (int i = 0; i < k - 1; i++) {
            push(i);
        }
        for (int i = k - 1; i < n; i++) {
            push(i);
            res[i + 1 - k] = max();
            pop(i + 1 - k);
        }
        return res;
    }
}
