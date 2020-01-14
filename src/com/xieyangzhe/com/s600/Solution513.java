package com.xieyangzhe.com.s600;

import com.xieyangzhe.com.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 14/1/20
 */
public class Solution513 {
    //513. Find Bottom Left Tree Value
    //Given a binary tree, find the leftmost value in the last row of the tree.
    //
    //Example 1:
    //Input:
    //
    //    2
    //   / \
    //  1   3
    //
    //Output:
    //1
    //Example 2:
    //Input:
    //
    //        1
    //       / \
    //      2   3
    //     /   / \
    //    4   5   6
    //       /
    //      7
    //
    //Output:
    //7
    //Note: You may assume the tree (i.e., the given root node) is not NULL.
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
