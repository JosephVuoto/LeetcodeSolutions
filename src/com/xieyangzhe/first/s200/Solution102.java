package com.xieyangzhe.first.s200;

import com.xieyangzhe.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 12/12/19
 */
public class Solution102 {
    //102. Binary Tree Level Order Traversal
    //Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
    //
    //For example:
    //Given binary tree [3,9,20,null,null,15,7],
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //return its level order traversal as:
    //[
    //  [3],
    //  [9,20],
    //  [15,7]
    //]
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(tmp);
        }
        return result;
    }
}
