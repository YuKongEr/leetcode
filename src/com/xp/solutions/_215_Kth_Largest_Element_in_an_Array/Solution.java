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

    private void quickSort(int[] list, int left, int right) {
        if (left < right) {
            int base = division(list, left, right);
            quickSort(list,left, base - 1);
            quickSort(list, base + 1, right);
        }
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

}
