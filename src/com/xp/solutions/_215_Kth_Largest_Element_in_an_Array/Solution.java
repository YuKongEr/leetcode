package com.xp.solutions._215_Kth_Largest_Element_in_an_Array;

import java.io.File;

/**
 * @author yukong
 * @date 2019-05-13 14:42
 */
public class Solution {

    private int division(int[] list, int left, int right) {
        int base = list[left];
        while(left < right) {
            // 从右往左找到第一个比base小的数
            while(left < right  && base < list[right]){
                right --;
            }
            // 交换
            list[left] = list[right];
            // 从左往右找到第一个比base大的数
            while (left  < right && base > list[left]){
                left ++;
            }
            list[right] = list[left];
        }
        list[left] = base;
        return left;
    }

    private int findKthLargest(int[] list, int k){
        k = list.length - k;
        int l = 0, h = list.length - 1;
        while (l < h) {
            int j = division(list, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1; }
        }
        return list[k];
    }



    Random random = new Random();
    // 快排 partition解决
    public int findKthLargest1(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        // 从小到大排序
        k = right - k + 1;
        while(left < right) {
            int index = partition(nums, left, right);
            if (index == k) {
                break;
            } else if (index < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return nums[k];
    }

    // 快排的分区
    private int partition(int[] nums, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            int tmp = nums[left];
            nums[left] = nums[randomIndex];
            nums[randomIndex] = tmp;
        }
        int base = nums[left];
        while(left < right) {
            // 从右向左 找到第一个比base小的数字
            while(left < right && nums[right] > base) {
                right--;
            }
            // 交换
            nums[left] = nums[right];
            // 从左向右 找到第一个比base大的数字
            while(left < right && nums[left] <= base) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = base;
        return left;
    }

}
