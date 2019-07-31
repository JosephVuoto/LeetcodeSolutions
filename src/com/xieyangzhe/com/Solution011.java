package com.xieyangzhe.com;
// 11. Container With Most Water
//  Input: [1,8,6,2,5,4,8,3,7]
//  Output: 49

public class Solution011 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
