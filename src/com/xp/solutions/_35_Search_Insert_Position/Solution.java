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
}
