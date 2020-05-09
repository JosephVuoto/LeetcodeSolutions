package com.xieyangzhe.second;

import com.xieyangzhe.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 9/5/20
 */
public class Solution653 {
    //653. Two Sum IV - Input is a BST
    //Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
    //
    //Example 1:
    //
    //Input:
    //    5
    //   / \
    //  3   6
    // / \   \
    //2   4   7
    //
    //Target = 9
    //
    //Output: True
    //
    //
    //Example 2:
    //
    //Input:
    //    5
    //   / \
    //  3   6
    // / \   \
    //2   4   7
    //
    //Target = 28
    //
    //Output: False
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
