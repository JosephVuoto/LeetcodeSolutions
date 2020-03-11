package com.xieyangzhe.com.first.s400;

import java.util.*;

/**
 * @author Yangzhe Xie
 * @date 3/1/20
 */
public class Solution349 {
    //349. Intersection of Two Arrays
    //Given two arrays, write a function to compute their intersection.
    //
    //Example 1:
    //
    //Input: nums1 = [1,2,2,1], nums2 = [2,2]
    //Output: [2]
    //Example 2:
    //
    //Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //Output: [9,4]
    //Note:
    //
    //Each element in the result must be unique.
    //The result can be in any order.
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }
        for (int num: nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for (int num: set2) {
            result[index++] = num;
        }
        return result;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] ret = new int[res.size()];
        for (int k = 0; k < ret.length; k++) {
            ret[k] = res.get(k);
        }
        return ret;
    }
}
