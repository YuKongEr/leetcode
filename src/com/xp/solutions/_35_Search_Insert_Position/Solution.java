package com.xp.solutions._35_Search_Insert_Position;

/**
 * @author yukong
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }


    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = right + 1;
        while(left <= right) {
            int mid =  left + ((right - left ) >> 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = left + 1;
            }
        }
        return ans;
    }
}
}
