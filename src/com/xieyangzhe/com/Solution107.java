package com.xieyangzhe.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its bottom-up level order traversal as:
//        [
//        [15,7],
//        [9,20],
//        [3]
//        ]
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        travel(root, answer, 1);
        Collections.reverse(answer);
        return answer;
    }

    private void travel(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }
        if (res.size() < level) {
            res.add(new ArrayList<>());
        }
        res.get(level - 1).add(node.val);
        travel(node.left, res, level + 1);
        travel(node.right, res, level + 1);
    }
}
