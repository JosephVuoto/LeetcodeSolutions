package com.xieyangzhe.com.s200;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yangzhe Xie
 * @date 30/12/19
 */
public class Solution220 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
