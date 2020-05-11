package com.xieyangzhe.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 11/5/20
 */
public class Solution658 {
    //658. Find K Closest Elements
    //Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
    //
    //
    //
    //Example 1:
    //
    //Input: arr = [1,2,3,4,5], k = 4, x = 3
    //Output: [1,2,3,4]
    //Example 2:
    //
    //Input: arr = [1,2,3,4,5], k = 4, x = -1
    //Output: [1,2,3,4]
    //
    //
    //Constraints:
    //
    //1 <= k <= arr.length
    //1 <= arr.length <= 10^4
    //Absolute value of elements in the array and x will not exceed 104

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
