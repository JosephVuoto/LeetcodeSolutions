package com.xieyangzhe.third;

import com.xieyangzhe.common.TreeNode;

/**
 * @author Yangzhe Xie
 * @date 11/7/20
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
