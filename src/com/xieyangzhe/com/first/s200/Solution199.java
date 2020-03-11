package com.xieyangzhe.com.first.s200;

import com.xieyangzhe.com.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 24/12/19
 */
public class Solution199 {
    //199. Binary Tree Right Side View
    //Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
    //
    //Example:
    //
    //Input: [1,2,3,null,5,null,4]
    //Output: [1, 3, 4]
    //Explanation:
    //
    //   1            <---
    // /   \
    //2     3         <---
    // \     \
    //  5     4       <---
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int siz = queue.size();
            for (int i = 0; i < siz; i++) {
                TreeNode tmp = queue.poll();
                if (i == siz - 1) {
                    result.add(tmp.val);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
        return result;
    }
}
