package com.xieyangzhe.com.s200;

import com.xieyangzhe.com.common.ListNode;
import com.xieyangzhe.com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 18/12/19
 */
public class Solution144 {
    //144. Binary Tree Preorder Traversal
    //Given a binary tree, return the preorder traversal of its nodes' values.
    //
    //Example:
    //
    //Input: [1,null,2,3]
    //   1
    //    \
    //     2
    //    /
    //   3
    //
    //Output: [1,2,3]
    //Follow up: Recursive solution is trivial, could you do it iteratively?

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop().right;
            }
        }
        return result;
    }
}
