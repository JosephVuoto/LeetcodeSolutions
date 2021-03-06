package com.xieyangzhe.third;

/**
 * @author Yangzhe Xie
 * @date 5/7/20
 */
public class Solution088 {
    //88. 合并两个有序数组
    //给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
    //
    //
    //
    //说明:
    //
    //初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
    //你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
    //
    //
    //示例:
    //
    //输入:
    //nums1 = [1,2,3,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //
    //输出: [1,2,2,3,5,6]
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, cur = m + n - 1;
        while (i >= 0 && j >= 0 && cur >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[cur--] = nums1[i--];
            } else {
                nums1[cur--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[cur--] = nums2[j--];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsTmp = new int[m];
        System.arraycopy(nums1, 0, numsTmp, 0, m);
        int i = 0, j = 0, cur = 0;
        while (i < m && j < n) {
            if (numsTmp[i] <= nums2[j]) {
                nums1[cur++] = numsTmp[i++];
            } else {
                nums1[cur++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[cur++] = numsTmp[i++];
        }
        while (j < n) {
            nums1[cur++] = nums2[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,0,0,0};
        new Solution088().merge1(nums, 3, new int[]{2,5,6}, 3);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
