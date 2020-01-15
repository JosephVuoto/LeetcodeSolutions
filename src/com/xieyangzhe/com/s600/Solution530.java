package com.xieyangzhe.com.s600;

import com.xieyangzhe.com.common.TreeNode;

import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 15/1/20
 */
public class Solution530 {
    //530. Minimum Absolute Difference in BST
    //Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
    //
    //Example:
    //
    //Input:
    //
    //   1
    //    \
    //     3
    //    /
    //   2
    //
    //Output:
    //1
    //
    //Explanation:
    //The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
    //
    //
    //Note: There are at least two nodes in this BST.
    Integer prev;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null)
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        prev = root.val;
        inorder(root.right);
    }
}
