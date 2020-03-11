package com.xieyangzhe.com.second;

import com.xieyangzhe.com.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 12/3/20
 */
//24. Swap Nodes in Pairs
//Medium
//
//1809
//
//154
//
//Add to List
//
//Share
//Given a linked list, swap every two adjacent nodes and return its head.
//
//You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//
//
//Example:
//
//Given 1->2->3->4->5->6, you should return the list as 2->1->4->3->6->5.
//Accepted
//416,955
//Submissions
//860,691
public class Solution024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }

    private ListNode reversList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = reversList1(head.next);
        head.next.next = head;
        head.next = null;
        return preHead;
    }

    private ListNode reversList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.fromList(1, 2, 3, 4, 5, 6);
        System.out.println(new Solution024().swapPairs(node).toList());
    }
}
