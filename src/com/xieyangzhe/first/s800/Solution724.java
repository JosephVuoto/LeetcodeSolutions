package com.xieyangzhe.first.s800;

/**
 * @author Yangzhe Xie
 * @date 31/1/20
 */
public class Solution724 {
    //724. Find Pivot Index
    //Given an array of integers nums, write a method that returns the "pivot" index of this array.
    //
    //We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
    //
    //If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
    //
    //Example 1:
    //
    //Input:
    //nums = [1, 7, 3, 6, 5, 6]
    //Output: 3
    //Explanation:
    //The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
    //Also, 3 is the first index where this occurs.
    //
    //
    //Example 2:
    //
    //Input:
    //nums = [1, 2, 3]
    //Output: -1
    //Explanation:
    //There is no index that satisfies the conditions in the problem statement.
    //
    //
    //Note:
    //
    //The length of nums will be in the range [0, 10000].
    //Each element nums[i] will be an integer in the range [-1000, 1000].
    public int pivotIndex(int[] nums) {
        int i = 0, j = nums.length - 1, left = nums[i], right = nums[j];
        while (i < j) {
            if (left < right) {
                i++;
                left += nums[i];
            } else if (left > right) {
                j--;
                right += nums[j];
            } else {
                if (j - i == 1) {
                    return j - 1;
                } else {
                    i++;
                    left += nums[i];
                    j--;
                    right += nums[j];
                }
            }
        }
        return -1;
    }

    public int pivotIndex1(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) {
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }
}
