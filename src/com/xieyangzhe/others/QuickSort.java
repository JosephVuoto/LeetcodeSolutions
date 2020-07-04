package com.xieyangzhe.others;

/**
 * @author Yangzhe Xie
 * @date 30/6/20
 */
public class QuickSort {
    private static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int tmp = nums[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && nums[j] > tmp) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] < tmp) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = tmp;
            quickSort(nums, start, i - 1);
            quickSort(nums, i + 1, end);
        }
    }

    private static int quickSelect(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int tmp = nums[start];
        int i = start, j = end;
        while (i < j) {
            while (j > i && nums[j] > tmp) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] < tmp) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = tmp;
        if (i == target) {
            return nums[i];
        } else if (i < target) {
            return quickSelect(nums, i + 1, end, target);
        } else {
            return quickSelect(nums, start, i - 1, target);
        }
    }
}
