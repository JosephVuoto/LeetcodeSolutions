package com.xieyangzhe.second;

import com.xieyangzhe.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 10/3/20
 */
public class Solution002 {
    //    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
//    Explanation: 342 + 465 = 807.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            int cur = l1.val + l2.val + flag;
            if (cur > 9) {
                flag = 1;
                cur -= 10;
            } else {
                flag = 0;
            }
            tmp.next = new ListNode(cur);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int cur = l1.val + flag;
            if (cur > 9) {
                flag = 1;
                cur -= 10;
            } else {
                flag = 0;
            }
            tmp.next = new ListNode(cur);
            tmp = tmp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int cur = l2.val + flag;
            if (cur > 9) {
                flag = 1;
                cur -= 10;
            } else {
                flag = 0;
            }
            tmp.next = new ListNode(cur);
            tmp = tmp.next;
            l2 = l2.next;
        }
        if (flag == 1) {
            tmp.next = new ListNode(1);
        }

        return head.next;
    }
}
