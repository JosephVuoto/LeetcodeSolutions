package com.xieyangzhe.first.s100;

import com.xieyangzhe.common.ListNode;

//        19. Remove Nth Node From End of List
//        Given a linked list, remove the n-th node from the end of list and return its head.
//
//        Example:
//
//        Given linked list: 1->2->3->4->5, and n = 2.
//
//        After removing the second node from the end, the linked list becomes 1->2->3->5.
//        Note:
//
//        Given n will always be valid.
//
//        Follow up:
//
//        Could you do this in one pass?
public class Solution019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode node = head; node.next != null; node = node.next) {
            length++;
        }
        length -= n;
        ListNode first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
