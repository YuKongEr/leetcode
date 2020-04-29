package com.xp.solutions._1095_Find_in_Mountain_Array;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/29 10:09
 */
public class Solution {
    interface MountainArray {
        public int get(int index);

        public int length();
    }


    class MountainArrayImpl implements MountainArray {
        private int[] arr;
        private int size;

        public MountainArrayImpl(int[] arr) {
            this.arr = arr;
            this.size = this.arr.length;
        }

        @Override
        public int get(int index) {
            return this.arr[index];
        }

        @Override
        public int length() {
            return this.size;
        }

    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int maximum = findMaximum(mountainArr);
        int lr = findTarget(mountainArr, 0, maximum, target, false);
        if(lr != -1) {
            return lr;
        }
        return findTarget(mountainArr, maximum + 1, mountainArr.length() - 1, target, true);
    }

    private int findMaximum(MountainArray mountainArray) {
        int left = 0, right = mountainArray.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 取左中位数，因为进入循环，数组一定至少有 2 个元素
            // 因此，左中位数一定有右边元素，数组下标不会发生越界
            if (mountainArray.get(mid) < mountainArray.get(mid + 1)) {
                // 如果当前的数比右边的数小，它一定不是山顶
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findTarget(MountainArray mountainArray, int left , int right, int target, boolean isDesc) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(less(isDesc, mountainArray.get(mid),target)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(mountainArray.get(left) == target) {
            return left;
        }
        return -1;
    }

    private boolean less(boolean isDesc, int number, int target) {
        if(isDesc) {
            return number > target;
        }
        return number < target;
    }
}
