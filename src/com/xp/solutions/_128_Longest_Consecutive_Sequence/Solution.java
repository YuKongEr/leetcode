package com.xp.solutions._128_Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @author yukongcode@gmail.com
 * @date 2020/4/6 15:09
 */
public class Solution {
    Map<Integer, Integer> um = new HashMap<>();
    Map<Integer, Integer> cnt = new HashMap<>();

    /**
     * 归并集解法
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            um.put(num, num);
            cnt.put(num, 1);
        }
        int ans = 1;
        for (int i : nums) {
            if (i != Integer.MAX_VALUE && um.containsKey(i + 1)) {
                ans = Math.max(ans, merge(i, i + 1));
            }
        }
        return ans;
    }

    private int find(int i) {
        if (i == um.get(i)) {
            return i;
        }
        // 压缩路径
        int res = find(um.get(um.get(i)));
        um.put(i, res);
        return res;
    }

    private int merge(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return cnt.get(px);
        }
        um.put(y, px);
        cnt.put(px, cnt.get(px) + cnt.get(py));
        return cnt.get(px);
    }

    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for(int i: set){
            // 假如一个数在哈希表中存在比他小的，那么它不是可以作为开头的数字
            if(i != Integer.MIN_VALUE && set.contains(i-1)){
                continue;
            }
            int cnt = 1;
            while(i!=Integer.MAX_VALUE && set.contains(i+1)){
                cnt ++;
                i++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;

    }

    public static void main(String[] args) {
        new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        new Solution().longestConsecutive(new int[]{0});
    }
}
