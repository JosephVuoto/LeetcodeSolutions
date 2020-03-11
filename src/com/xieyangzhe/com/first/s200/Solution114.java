package com.xieyangzhe.com.first.s200;

import com.xieyangzhe.com.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 13/12/19
 */
public class Solution114 {
    //114. Flatten Binary Tree to Linked List
    //Given a binary tree, flatten it to a linked list in-place.
    //
    //For example, given the following tree:
    //
    //    1
    //   / \
    //  2   5
    // / \   \
    //3   4   6
    //The flattened tree should look like:
    //
    //1
    // \
    //  2
    //   \
    //    3
    //     \
    //      4
    //       \
    //        5
    //         \
    //          6
    public void flatten(TreeNode root) {
        getAns(root, null);
    }

    private TreeNode getAns(TreeNode root, TreeNode last) {
        if (root == null) return last;
        root.right = getAns(root.left, getAns(root.right, last));
        root.left = null;
        return root;
    }
}
