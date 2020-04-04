package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 2/4/20
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
    //Trivia:
    //This problem was inspired by this original tweet by Max Howell:
    //
    //Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
