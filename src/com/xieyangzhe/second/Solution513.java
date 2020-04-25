package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 25/4/20
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

    private int maxDepth = 0;
    private int val = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return val;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            val = node.val;
            maxDepth = depth;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasAdded = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!hasAdded) {
                    result = node.val;
                    hasAdded = true;
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
