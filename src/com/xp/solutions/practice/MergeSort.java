package com.xp.solutions.practice;

/**
 * @author yukong
 * @date 2020/6/27 15:59
 */
public class MergeSort {

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 2);
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = 0, q = mid + 1, p = left;
        while (p <= mid && q <= right) {
            tmp[i++] = nums[p] < nums[q] ? nums[p++] : nums[q++];
        }
        while (p <= mid) {
            tmp[i++] = nums[p++];
        }
        while (q <= right) {
            tmp[i++] = nums[q++];
        }
        for (q = 0; q < tmp.length; q++) {
            nums[left + q] = tmp[q];
        }
    }

    public static void main(String[] args) {
        int[] n = new int[]{1, 4, -1, 2, 3, 3, 2};
        new MergeSort().sort(n, 0, n.length - 1);
        for (int i : n) {
            System.out.print(i + " ");
        }
    }

}
