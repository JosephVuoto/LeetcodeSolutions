package com.xieyangzhe.com.first.s600;

import com.xieyangzhe.com.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 14/1/20
 */
public class Solution515 {
    //515. Find Largest Value in Each Tree Row
    //You need to find the largest value in each row of a binary tree.
    //
    //Example:
    //Input:
    //
    //          1
    //         / \
    //        3   2
    //       / \   \
    //      5   3   9
    //
    //Output: [1, 3, 9]
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int tmpMax = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                tmpMax = Math.max(node.val, tmpMax);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(tmpMax);
        }
        return result;
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int depth) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }
        helper(root.left, res, depth + 1);
        helper(root.right, res, depth + 1);
    }
}
