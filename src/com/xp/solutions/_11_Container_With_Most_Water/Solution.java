package com.xp.solutions._11_Container_With_Most_Water;

/**
 * @author yukong
 * @version V1.0
 * @Package com.xp.solutions._11_Container_With_Most_Water
 * @Description: TODO
 * @date 2018/1/22 15:04
 **/
public class Solution {

    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(((right - left) * Math.min(height[left], height[right])), maxArea);
            if (height[left] < height[right] ){
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }

}
