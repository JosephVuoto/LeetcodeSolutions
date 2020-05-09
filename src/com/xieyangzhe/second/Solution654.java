package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 9/5/20
 */
public class Solution654 {
    //654. Maximum Binary Tree
    //Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
    //
    //The root is the maximum number in the array.
    //The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    //The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
    //Construct the maximum tree by the given array and output the root node of this tree.
    //
    //Example 1:
    //Input: [3,2,1,6,0,5]
    //Output: return the tree root node representing the following tree:
    //
    //      6
    //    /   \
    //   3     5
    //    \    /
    //     2  0
    //       \
    //        1
    //Note:
    //The size of the given array will be in the range [1,1000].
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start < 0 || end > nums.length - 1 || start > end) {
            return null;
        }
        int maxVal = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                maxIndex = i;
                maxVal = nums[i];
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = construct(nums, start, maxIndex - 1);
        node.right = construct(nums, maxIndex + 1, end);
        return node;
    }
}
