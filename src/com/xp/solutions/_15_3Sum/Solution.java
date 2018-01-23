package com.xp.solutions._15_3Sum;

import java.util.*;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._15_3Sum
 * @Description: TODO
 * @date 2018/1/23 16:07
 **/
public class Solution {
    public  List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if ( i > 0 && nums[i] == nums[i-1]) {
                continue;
            } else {
                List<List<Integer>> temp = twoSum(nums, i + 1, nums.length-1, nums[i]);
                for (List<Integer> list: temp) {
                    result.add(list);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int begin, int end, int target) {
        int i = begin;
        int j = end;
        List<List<Integer>> result = new ArrayList<>();
        while (i < j) {
            if (nums[i] + nums[j] + target == 0 ) {
                result.add(Arrays.asList(target,nums[i], nums[j]));
                while (i < j && nums[i] == nums[i+1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j-1]) {
                    j--;
                }
                i++;
                j--;
            } else if (nums[i] + nums[j] + target < 0) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }


}
