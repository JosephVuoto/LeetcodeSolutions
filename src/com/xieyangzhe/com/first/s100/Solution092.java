package com.xieyangzhe.com.first.s100;

import com.xieyangzhe.com.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 11/12/19
 */
public class Solution092 {
    public static void main(String[] args) {
        ListNode head = ListNode.fromList(1, 2, 3, 4, 5);
        System.out.println(new Solution092().reverseBetweenSimple(head, 3, 5).toList());
    }

    //92. Reverse Linked List II
    //Reverse a linked list from position m to n. Do it in one-pass.
    //
    //Note: 1 ≤ m ≤ n ≤ length of list.
    //
    //Example:
    //
    //Input: 1->2->3->4->5->NULL, m = 2, n = 4
    //Output: 1->4->3->2->5->NULL
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur = head, pre = m == 1 ? null : head;
        ListNode newHead = m == 1 ? null : head;
        for (int i = 2; i < m && pre != null; i++) {
            pre = pre.next;
        }
        if (pre != null) {
            cur = pre.next;
        }
        ListNode sav = pre;
        ListNode las = cur;
        pre = cur;
        cur = cur.next;
        for (int i = 0; i < n - m; i++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        las.next = cur;
        if (sav != null) {
            sav.next = pre;
        }

        if (newHead == null) {
            newHead = pre;
        }

        return newHead;
    }

    public ListNode reverseBetweenSimple(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
