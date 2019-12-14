package com.xieyangzhe.com.s200;

import com.xieyangzhe.com.common.TreeNode;

import java.util.Stack;

public class Solution106 {
    //106. Construct Binary Tree from Inorder and Postorder Traversal
    //Given inorder and postorder traversal of a tree, construct the binary tree.
    //
    //Note:
    //You may assume that duplicates do not exist in the tree.
    //
    //For example, given
    //
    //inorder = [9,3,15,20,7]
    //postorder = [9,15,7,20,3]
    //Return the following binary tree:
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return getAns(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode getAns(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode current = new TreeNode(postorder[postEnd]);
        int in = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                in = i;
            }
        }
        current.left = getAns(inorder, postorder, postEnd - inEnd + in - 1, inStart, in - 1);
        current.right = getAns(inorder, postorder, postEnd - 1, in + 1, inEnd);
        return current;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;

        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }

        return root;
    }
}