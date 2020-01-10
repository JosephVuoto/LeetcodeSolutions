package com.xieyangzhe.com.s300;

import com.xieyangzhe.com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 2/1/20
 */
public class Solution230 {
    //230. Kth Smallest Element in a BST
    //Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
    //
    //Note:
    //You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
    //
    //Example 1:
    //
    //Input: root = [3,1,4,null,2], k = 1
    //   3
    //  / \
    // 1   4
    //  \
    //   2
    //Output: 1
    //Example 2:
    //
    //Input: root = [5,3,6,2,4,null,null,1], k = 3
    //       5
    //      / \
    //     3   6
    //    / \
    //   2   4
    //  /
    // 1
    //Output: 3
    //Follow up:
    //What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty() || root != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                if (--k == 0) {
                    return node.val;
                }
                node = node.right;
            }
        }
        return 0;
    }
}