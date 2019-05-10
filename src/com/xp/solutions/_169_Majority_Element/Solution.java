package com.xp.solutions._169_Majority_Element;

/**
 * @author yukong
 * @date 2019-05-06 14:54
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Solution {

    public  static int majorityElement(int[] nums) {
        int m=0,n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==m){
                n++;
            }
            else{
                if(n==0){
                    m=nums[i];
                    n++;
                }
                else{
                    n--;
                }
            }
        }
        return m;
    }



    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,1};
        System.out.println(majorityElement(arr));
    }
}
