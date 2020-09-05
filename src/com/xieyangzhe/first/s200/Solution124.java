package com.xieyangzhe.first.s200;

import com.xieyangzhe.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 5/9/20
 */
public class Solution124 {
    //124. Binary Tree Maximum Path Sum
    //Given a non-empty binary tree, find the maximum path sum.
    //
    //For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
    //
    //Example 1:
    //
    //Input: [1,2,3]
    //
    //       1
    //      / \
    //     2   3
    //
    //Output: 6
    //Example 2:
    //
    //Input: [-10,9,20,null,null,15,7]
    //
    //   -10
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    //Output: 42
    private int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        helper(root);
        return result;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        result = Math.max(result, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
