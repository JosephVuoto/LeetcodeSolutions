package com.xieyangzhe.com.s700;

import com.xieyangzhe.com.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yangzhe Xie
 * @date 21/1/20
 */
public class Solution662 {
    //662. Maximum Width of Binary Tree
    //Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
    //
    //The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
    //
    //Example 1:
    //
    //Input:
    //
    //           1
    //         /   \
    //        3     2
    //       / \     \
    //      5   3     9
    //
    //Output: 4
    //Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
    //Example 2:
    //
    //Input:
    //
    //          1
    //         /
    //        3
    //       / \
    //      5   3
    //
    //Output: 2
    //Explanation: The maximum width existing in the third level with the length 2 (5,3).
    //Example 3:
    //
    //Input:
    //
    //          1
    //         / \
    //        3   2
    //       /
    //      5
    //
    //Output: 2
    //Explanation: The maximum width existing in the second level with the length 2 (3,2).
    //Example 4:
    //
    //Input:
    //
    //          1
    //         / \
    //        3   2
    //       /     \
    //      5       9
    //     /         \
    //    6           7
    //Output: 8
    //Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
    //
    //
    //Note: Answer will in the range of 32-bit signed integer.
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();

        indexQueue.add(0);
        nodeQueue.add(root);
        int max = 1;
        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size(), left = 0, right = 0;
            for (int i = 0; i < levelSize; i++) {
                int index = indexQueue.poll();
                TreeNode node = nodeQueue.poll();
                if (i == 0) {
                    left = index;
                }
                if (i == levelSize - 1) {
                    right = index;
                }
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    indexQueue.add(index * 2);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    indexQueue.add(index * 2 + 1);
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
