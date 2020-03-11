package com.xieyangzhe.com.first.s300;

import com.xieyangzhe.com.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 25/12/19
 */
public class Solution226 {
    //226. Invert Binary Tree
    //Invert a binary tree.
    //
    //Example:
    //
    //Input:
    //
    //     4
    //   /   \
    //  2     7
    // / \   / \
    //1   3 6   9
    //Output:
    //
    //     4
    //   /   \
    //  7     2
    // / \   / \
    //9   6 3   1
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
