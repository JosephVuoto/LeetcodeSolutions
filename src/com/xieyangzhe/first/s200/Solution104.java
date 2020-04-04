package com.xieyangzhe.first.s200;

import com.xieyangzhe.common.TreeNode;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
