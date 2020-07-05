package com.xieyangzhe.third;

/**
 * @author Yangzhe Xie
 * @date 5/7/20
 */
public class Solution209 {
    //209. 长度最小的子数组
    //给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
    //
    //
    //
    //示例：
    //
    //输入：s = 7, nums = [2,3,1,2,4,3]
    //输出：2
    //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    //
    //
    //进阶：
    //
    //如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, result = Integer.MAX_VALUE, tmp = 0, cnt = 0;
        while (left < nums.length && right < nums.length) {
            if (tmp < s) {
                tmp += nums[right++];
                cnt++;
            }
            while (tmp >= s && cnt > 0) {
                result = Math.min(result, cnt);
                tmp -= nums[left++];
                cnt--;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
