package com.xieyangzhe.com.s100;

import com.xieyangzhe.com.common.TreeNode;

import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 12/12/19
 */
public class Solution098 {
    //98. Validate Binary Search Tree
    //Given a binary tree, determine if it is a valid binary search tree (BST).
    //
    //Assume a BST is defined as follows:
    //
    //The left subtree of a node contains only nodes with keys less than the node's key.
    //The right subtree of a node contains only nodes with keys greater than the node's key.
    //Both the left and right subtrees must also be binary search trees.
    //
    //
    //Example 1:
    //
    //    2
    //   / \
    //  1   3
    //
    //Input: [2,1,3]
    //Output: true
    //Example 2:
    //
    //    5
    //   / \
    //  1   4
    //     / \
    //    3   6
    //
    //Input: [5,1,4,null,null,3,6]
    //Output: false
    //Explanation: The root node's value is 5 but its right child's value is 4.
    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (root.left != null) {
                int max = getMaxOfBST(root.left);
                if (root.val <= max) {
                    return false;
                }
            }

        } else {
            return false;
        }

        if (isValidBST(root.right)) {
            if (root.right != null) {
                int min = getMinOfBST(root.right);
                return root.val < min;
            }

        } else {
            return false;
        }
        return true;
    }

    private int getMinOfBST(TreeNode root) {
        int min = root.val;
        while (root != null) {
            if (root.val <= min) {
                min = root.val;
            }
            root = root.left;
        }
        return min;
    }

    private int getMaxOfBST(TreeNode root) {
        int max = root.val;
        while (root != null) {
            if (root.val >= max) {
                max = root.val;
            }
            root = root.right;
        }
        return max;
    }
    /* ------------------------------------------------ */

    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
