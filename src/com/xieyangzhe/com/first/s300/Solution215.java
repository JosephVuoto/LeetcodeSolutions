package com.xieyangzhe.com.first.s300;

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
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    int findKthLargest1(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int lo, int hi, int k /* index we're looking for */) {
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j) {
            if (nums[i++] > pivot) swap(nums, --i, --j);
        }
        swap(nums, i, hi);
        if (i == k)
            return nums[i];
        else if (i > k)
            return quickSelect(nums, lo, i - 1, k);
        else
            return quickSelect(nums, i + 1, hi, k);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
