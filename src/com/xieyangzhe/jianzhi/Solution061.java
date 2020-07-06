package com.xieyangzhe.jianzhi;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yangzhe Xie
 * @date 6/7/20
 */
public class Solution061 {
    //剑指 Offer 61. 扑克牌中的顺子
    //从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
    //
    //
    //
    //示例 1:
    //
    //输入: [1,2,3,4,5]
    //输出: True
    //
    //
    //示例 2:
    //
    //输入: [0,0,1,2,5]
    //输出: True
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int totalDiff = 0, numZero = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                numZero++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            } else {
                totalDiff += (nums[i + 1] - nums[i] - 1);
            }
        }
        return numZero >= totalDiff;
    }

    public static void main(String[] args) {
        System.out.println(new Solution061().isStraight(new int[] {1,2,3,4,5}));
    }
}
