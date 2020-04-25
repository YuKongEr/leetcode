package com.xp.solutions._46_Permutations;

import java.util.*;

/**
 * @author yukongcode@gmail.com
 * @date 2020/4/25 17:36
 */
public class Solution {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> sequence = new LinkedList<>();
        backtrace(nums, sequence);
        return res;
    }

    private void backtrace(int[] nums, LinkedList<Integer> sequence) {
        if(sequence.size() == nums.length) {
                res.add(new LinkedList<>(sequence));
            return ;
        }
        for (int num : nums) {
            if(sequence.contains(num)) {
                continue;
            }
            sequence.add(num);
            backtrace(nums, sequence);
            sequence.removeLast();
        }
    }
}
