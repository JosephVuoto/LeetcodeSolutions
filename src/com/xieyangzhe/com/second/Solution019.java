package com.xieyangzhe.com.second;

import com.xieyangzhe.com.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 12/3/20
 */
//19. Remove Nth Node From End of List
//Medium
//
//2682
//
//195
//
//Add to List
//
//Share
//Given a linked list, remove the n-th node from the end of list and return its head.
//
//Example:
//
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//
//Given n will always be valid.
//
//Follow up:
//
//Could you do this in one pass?

    //1-2-3-4-5-6-7
    //3
    //1-2-3-4-6-7
public class Solution019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (--n > 0) {
            fast = fast.next;
        }
        if (fast.next == null) {
            return head.next;
        }
        ListNode slow = head;
        ListNode prev = new ListNode(-1);
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return head;
    }
}
