package com.xieyangzhe.second;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 26/6/20
 */
public class Solution042 {
    //42. Trapping Rain Water
    //Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
    //
    //
    //The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
    //
    //Example:
    //
    //Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    //Output: 6
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int h = Math.min(leftMax[i], rightMax[i]);
            if (h > height[i]) {
                result += (h - height[i]);
            }
        }
        return result;
    }

    public int trap1(int[] height) {
        int i = 0, j = height.length - 1;
        int result = 0, curHeight = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                curHeight = Math.max(height[i], curHeight);
                result += (curHeight - height[i]);
                i++;
            } else {
                curHeight = Math.max(height[j], curHeight);
                result += (curHeight - height[j]);
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution042().trap1(new int[]{3,2,1,0,2,3}));
    }
}
