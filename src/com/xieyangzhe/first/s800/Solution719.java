package com.xieyangzhe.first.s800;

import java.util.Arrays;

/**
 * @author Yangzhe Xie
 * @date 13/8/20
 */
public class Solution719 {
    //719. Find K-th Smallest Pair Distance
    //Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
    //
    //Example 1:
    //Input:
    //nums = [1,3,1]
    //k = 1
    //Output: 0
    //Explanation:
    //Here are all the pairs:
    //(1,3) -> 2
    //(1,1) -> 0
    //(3,1) -> 2
    //Then the 1st smallest distance pair is (1,1), and its distance is 0.
    //Note:
    //2 <= len(nums) <= 10000.
    //0 <= nums[i] < 1000000.
    //1 <= k <= len(nums) * (len(nums) - 1) / 2.
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int low = 0;
        int high = nums[len - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < len; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
