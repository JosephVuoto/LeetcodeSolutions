package com.xieyangzhe.first.s300;

import java.util.PriorityQueue;

/**
 * @author Yangzhe Xie
 * @date 25/12/19
 */
public class Solution215 {
    //215. Kth Largest Element in an Array
    //Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
    //
    //Example 1:
    //
    //Input: [3,2,1,5,6,4] and k = 2
    //Output: 5
    //Example 2:
    //
    //Input: [3,2,3,1,2,4,5,5,6] and k = 4
    //Output: 4
    //Note:
    //You may assume k is always valid, 1 ≤ k ≤ array's length.
    int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int tmp = nums[start];
        int i = start, j = end;
        while (i < j) {
            while (j > i && nums[j] >= tmp) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] < tmp) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = tmp;
        if (i == target) {
            return nums[i];
        } else if (i < target) {
            return quickSelect(nums, i + 1, end, target);
        } else {
            return quickSelect(nums, start, i - 1, target);
        }
    }
}
