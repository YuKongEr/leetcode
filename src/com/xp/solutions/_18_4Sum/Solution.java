package com.xp.solutions._18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yukong
 * @date: 2018/6/29 15:54
 * @description:
 */
public class Solution {

    /*public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return res;
        }
        //排序
        Arrays.sort(nums);
        int max = nums[len - 1];
        //4个最大的都比target小
        if (4 * max < target) {
            return res;
        }
        for (int i = 0; i < len - 3;) {
            if (nums[i] * 4 > target) {
                break;
            }
            if (nums[i] + 3 * max < target) {
                while (nums[i] == nums[++i] && i < len - 3) {};
                continue;
            }

            for (int j = i + 1; j < len - 2;) {
                int subSum = nums[i] + nums[j];
                if (nums[i] + nums[j] * 3 > target) {
                    break;
                }
                if (subSum + 2 * max < target) {
                    while (nums[j] == nums[++j] && j < len - 2) {};
                    continue;
                }

                int left = j + 1, right = len - 1;
                while (left < right) {
                    int sum = subSum + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (nums[left] == nums[++left] && left < right){};
                        while (nums[right] == nums[--right] && left < right){};
                    } else if (sum < target) {
                        ++left;
                    }
                    else {
                        --right;
                    }
                }
                while (nums[j] == nums[++j] && j < len - 2){} ;
            }
            while (nums[i] == nums[++i] && i < len - 3){} ;
        }
        return res;
    }*/


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), nums, 0, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> condition, int[] nums, int currIndex, int target) {
        if (condition.size() == 4) {
            if (getSum(condition)  == target) {
                res.add(new ArrayList<>(condition));
            }
            return;
        }
        if (currIndex > nums.length - 1) {
            return;
        }

        for (int i = currIndex; i < nums.length; i++) {
            // 重复跳过
            if (i != currIndex && nums[i] == nums[i-1]) {
                continue;
            }
            condition.add(nums[i]);
            // 当前和比target大 而且下一个数是正数
            if (getSum(condition) > target && nums[i] > 0) {
                if (!condition.isEmpty()) {
                    condition.remove(condition.size() - 1);

                }
                return;
            }
            dfs(res, condition, nums, i + 1, target);
            if (!condition.isEmpty()) {
                condition.remove(condition.size() - 1);
            }
        }
    }

    private int getSum(List<Integer> condition) {
        int sum = 0;
        for (int ele: condition) {
            sum += ele;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = solution.fourSum(nums,0);
        System.out.println(res);
    }

}
