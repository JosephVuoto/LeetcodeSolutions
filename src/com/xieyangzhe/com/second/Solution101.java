package com.xieyangzhe.com.second;

import com.xieyangzhe.com.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 23/3/20
 */
public class Solution101 {
    //101. Symmetric Tree
    //Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    //
    //For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    //
    //    1
    //   / \
    //  2   2
    // / \ / \
    //3  4 4  3
    //
    //
    //But the following [1,2,2,null,3,null,3] is not:
    //
    //    1
    //   / \
    //  2   2
    //   \   \
    //   3    3
    //
    //
    //Note:
    //Bonus points if you could solve it both recursively and iteratively.
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
