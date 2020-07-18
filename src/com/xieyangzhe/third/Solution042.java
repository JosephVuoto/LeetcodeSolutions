package com.xieyangzhe.third;

/**
 * @author Yangzhe Xie
 * @date 11/7/20
 */
public class Solution042 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, curHeight = 0, result = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                curHeight = Math.max(height[left], curHeight);
                result += (curHeight - height[left]);
                left++;
            } else {
                curHeight = Math.max(height[right], curHeight);
                result += (curHeight - height[right]);
                right--;
            }
        }
        return result;
    }
}
