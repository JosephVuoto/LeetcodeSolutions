package com.xieyangzhe.com.first.s100;

import com.xieyangzhe.com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 12/12/19
 */
public class Solution094 {
    //94. Binary Tree Inorder Traversal
    //Given a binary tree, return the inorder traversal of its nodes' values.
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
    //Output: [1,3,2]
    //Follow up: Recursive solution is trivial, could you do it iteratively?
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }
}
