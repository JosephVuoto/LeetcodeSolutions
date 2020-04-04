package com.xieyangzhe.first.s200;

import com.xieyangzhe.common.ListNode;
import com.xieyangzhe.common.TreeNode;

public class Solution109 {
    //109. Convert Sorted List to Binary Search Tree
    //Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
    //
    //For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    //
    //Example:
    //
    //Given the sorted linked list: [-10,-3,0,5,9],
    //
    //One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
    //
    //      0
    //     / \
    //   -3   9
    //   /   /
    // -10  5
    public TreeNode sortedListToBST(ListNode head) {
        return sortedArrayToBST(head, null);
    }

    private TreeNode sortedArrayToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedArrayToBST(head, slow);
        root.right = sortedArrayToBST(slow.next, tail);
        return root;
    }
}
