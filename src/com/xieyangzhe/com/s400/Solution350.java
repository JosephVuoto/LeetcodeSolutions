package com.xieyangzhe.com.s400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 2/1/20
 */
public class Solution350 {
    //350. Intersection of Two Arrays II
    //Given two arrays, write a function to compute their intersection.
    //
    //Example 1:
    //
    //Input: nums1 = [1,2,2,1], nums2 = [2,2]
    //Output: [2,2]
    //Example 2:
    //
    //Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //Output: [4,9]
    //Note:
    //
    //Each element in the result should appear as many times as it shows in both arrays.
    //The result can be in any order.
    //Follow up:
    //
    //What if the given array is already sorted? How would you optimize your algorithm?
    //What if nums1's size is small compared to nums2's size? Which algorithm is better?
    //What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int value : nums1) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (int value : nums2) {
            if (map.containsKey(value) && map.get(value) > 0) {
                result.add(value);
                map.put(value, map.get(value) - 1);
            }
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int index = 0;
        int[] ans = new int[res.size()];
        for (int num : res) {
            ans[index++] = num;
        }
        return ans;
    }
}
