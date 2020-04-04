package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 24/3/20
 */
//110. Balanced Binary Tree
//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as:
//
//a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//
//
//
//Example 1:
//
//Given the following tree [3,9,20,null,null,15,7]:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//Return true.
//
//Example 2:
//
//Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (leftHeight == -1 || rightHeight == -1 ||
                leftHeight - rightHeight > 1 ||
                rightHeight - leftHeight > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
