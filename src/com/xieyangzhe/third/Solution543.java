package com.xieyangzhe.third;

import com.xieyangzhe.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 11/7/20
 */
public class Solution543 {
    private int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return result;
    }

    private int maxHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxHeight(node.left);
        int right = maxHeight(node.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }
}
