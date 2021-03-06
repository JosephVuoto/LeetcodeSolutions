package com.xieyangzhe.second;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 3/5/20
 */
public class Solution594 {
    //594. Longest Harmonious Subsequence
    //We define a harmounious array as an array where the difference between its maximum value and its minimum value is exactly 1.
    //
    //Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
    //
    //Example 1:
    //
    //Input: [1,3,2,2,5,2,3,7]
    //Output: 5
    //Explanation: The longest harmonious subsequence is [3,2,2,2,3].
    public int findLHS(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key) + map.get(key + 1));
            }
        }
        return result;
    }
}
