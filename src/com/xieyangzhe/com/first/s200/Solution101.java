package com.xieyangzhe.com.first.s200;

import com.xieyangzhe.com.common.TreeNode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return checkVal(root, root);
    }

    public boolean checkVal(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val && checkVal(a.left, b.right) && checkVal(a.right, b.left);
    }
}
