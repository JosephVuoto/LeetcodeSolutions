package com.xieyangzhe.second;

import java.util.PriorityQueue;

/**
 * @author Yangzhe Xie
 * @date 31/3/20
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
    public int findKthLargest0(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, high);
        int count = high - pivot + 1;
        if (count == k) {
            return nums[pivot];
        }
        if (count > k) {
            return quickSelect(nums, pivot + 1, high, k);
        }
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
