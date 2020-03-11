package com.xieyangzhe.com.first.s200;

import com.xieyangzhe.com.common.TreeNode;

public class Solution105 {
    //105. Construct Binary Tree from Preorder and Inorder Traversal
    //Given preorder and inorder traversal of a tree, construct the binary tree.
    //
    //Note:
    //You may assume that duplicates do not exist in the tree.
    //
    //For example, given
    //
    //preorder = [3,9,20,15,7]
    //inorder = [9,3,15,20,7]
    //Return the following binary tree:
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getAns(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode getAns(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode current = new TreeNode(preorder[preStart]);
        int in = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                in = i;
            }
        }
        current.left = getAns(preorder, inorder, preStart + 1, inStart, in - 1);
        current.right = getAns(preorder, inorder, preStart + in - inStart + 1, in + 1, inEnd);
        return current;
    }
}