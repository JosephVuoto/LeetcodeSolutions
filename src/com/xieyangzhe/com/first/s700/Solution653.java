package com.xieyangzhe.com.first.s700;

import com.xieyangzhe.com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 20/1/20
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
        List<Integer> list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                l++;
            }
            else {
                r--;
            }
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
