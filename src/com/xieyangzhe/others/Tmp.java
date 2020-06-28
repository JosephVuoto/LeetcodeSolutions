package com.xieyangzhe.others;

import com.xieyangzhe.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 25/6/20
 */
public class Tmp {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 1, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (level > result.size()) {
            result.add(node.val);
        }
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,5,7,6,1};
        System.out.println(quickSelect(nums, 0, nums.length - 1, 6));
    }

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
