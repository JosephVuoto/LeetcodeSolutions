package com.xieyangzhe.com.first.s500;

import com.xieyangzhe.com.common.TreeNode;

import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 7/1/20
 */
public class Solution404 {
    //404. Sum of Left Leaves
    //Find the sum of all left leaves in a given binary tree.
    //
    //Example:
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    //There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left != null) {
                if (current.left.left == null && current.left.right == null) {
                    sum += current.left.val;
                }
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return sum;
    }
}
