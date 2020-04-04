package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 24/3/20
 */
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
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int startPre, int startIn, int endIn) {
        if (startIn > preorder.length - 1 || startIn > endIn) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[startPre]);
        int indexIn = 0;
        while (inorder[indexIn] != preorder[startPre]) {
            indexIn++;
        }
        node.left = build(preorder, inorder, startPre + 1, startIn, indexIn - 1);
        node.right = build(preorder, inorder, startPre + indexIn - startIn + 1, indexIn + 1, endIn);
        return node;
    }
}
