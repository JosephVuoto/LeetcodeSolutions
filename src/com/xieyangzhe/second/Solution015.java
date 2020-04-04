package com.xieyangzhe.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 11/3/20
 */
public class Solution015 {
    public static void main(String[] args) {
        System.out.println(new Solution015().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < right && nums[left - 1] == nums[left]);
                    do {
                        right--;
                    } while (left < right && nums[right + 1] == nums[right]);
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
