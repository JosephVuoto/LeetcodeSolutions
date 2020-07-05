package com.xieyangzhe.third;

import com.xieyangzhe.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 5/7/20
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmpNode = node.left;
            node.left = node.right;
            node.right = tmpNode;
            if (node.left != null) {
                queue.add(root.left);
            }
            if (node.right != null) {
                queue.add(root.right);
            }
        }
        return root;
    }
}
