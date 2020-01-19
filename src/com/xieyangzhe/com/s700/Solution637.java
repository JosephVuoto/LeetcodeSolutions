package com.xieyangzhe.com.s700;

import com.xieyangzhe.com.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 19/1/20
 */
public class Solution637 {
    //637. Average of Levels in Binary Tree
    //Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
    //Example 1:
    //Input:
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //Output: [3, 14.5, 11]
    //Explanation:
    //The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }
}
