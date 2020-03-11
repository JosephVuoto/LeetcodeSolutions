package com.xieyangzhe.com.first.s200;

import com.xieyangzhe.com.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 16/12/19
 */
public class Solution148 {
    public static void main(String[] args) {
        ListNode head1 = ListNode.fromList(1, 3, 5);
        ListNode head2 = ListNode.fromList(2, 4, 6);
        System.out.println(new Solution148().merge(head1, head2).toList());
    }

    //148. Sort List
    //Sort a linked list in O(n log n) time using constant space complexity.
    //
    //Example 1:
    //
    //Input: 4->2->1->3
    //Output: 1->2->3->4
    //Example 2:
    //
    //Input: -1->5->3->4->0
    //Output: -1->0->3->4->5
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head;
        if (left.val < right.val) {
            head = new ListNode(left.val);
            left = left.next;
        } else {
            head = new ListNode(right.val);
            right = right.next;
        }
        ListNode node = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = new ListNode(left.val);
                left = left.next;
            } else {
                node.next = new ListNode(right.val);
                right = right.next;
            }
            node = node.next;
        }
        if (left != null) {
            node.next = left;
        }
        if (right != null) {
            node.next = right;
        }
        return head;
    }
}
