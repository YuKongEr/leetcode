package com.xp.solutions._1248_Count_Number_of_Nice_Subarrays;

/**
 * @author yukong
 * @date 2020/5/20 23:53
 */
public class Solution {

    /**
     * 前缀和 + 状态法
     * @param nums
     * @param k
     * @return
     */
     public int numberOfSubarrays(int[] nums, int k) {
         int[] oddCount = new int[nums.length + 1];
         int odd = 0, ans = 0;
         oddCount[0] = 1;
         for(int i = 0; i < nums.length; i++) {
             // 只有nums[i] 为奇数 nums[i] & 1 才会为 1
             odd += nums[i] & 1;
             ans += odd >= k ? oddCount[odd - k] : 0;
             oddCount[odd] += 1;
         }
         return ans;
     }

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays1(int[] nums, int k) {
        int left = 0, right = 0;
        int ans = 0;
        int oddCount = 0;
        while (right < nums.length) {
            if ((nums[right] & 1) == 1) {
                oddCount++;
            }
            right++;
            // 如果已经是最美子数组 则开始计算个数
            if (oddCount == k) {
                int rightEven = 0;
                int leftEven = 0;
                // 计算左边的偶数个数
                while ((nums[left] & 1) == 0) {
                    left++;
                    leftEven++;
                }
                // 计算右边的偶数个数
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                    rightEven++;
                }
                ans += (leftEven + 1) * (rightEven + 1);
                left++;
                oddCount--;

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
        ;
    }
}
