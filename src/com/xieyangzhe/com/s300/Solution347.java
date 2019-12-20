package com.xieyangzhe.com.s300;

import java.util.*;

/**
 * @author Yangzhe Xie
 * @date 20/12/19
 */
public class Solution347 {
    //347. Top K Frequent Elements
    //Given a non-empty array of integers, return the k most frequent elements.
    //
    //Example 1:
    //
    //Input: nums = [1,1,1,2,2,3], k = 2
    //Output: [1,2]
    //Example 2:
    //
    //Input: nums = [1], k = 1
    //Output: [1]
    //Note:
    //
    //You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    //Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(counter::get));
        for (int n: counter.keySet()) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return new ArrayList<>(queue);
    }
}
