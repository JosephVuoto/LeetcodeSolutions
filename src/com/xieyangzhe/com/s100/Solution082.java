package com.xieyangzhe.com.s100;

import com.xieyangzhe.com.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 10/12/19
 */
public class Solution082 {
    public static void main(String[] args) {
        ListNode head = ListNode.fromList(1, 1, 1, 2, 3, 3, 4, 4, 5);
        System.out.println(new Solution082().deleteDuplicates(head).toList());
    }

    //82. Remove Duplicates from Sorted List II
    //Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
    //
    //Example 1:
    //
    //Input: 1->2->3->3->4->4->5
    //Output: 1->2->5
    //Example 2:
    //
    //Input: 1->1->1->2->3
    //Output: 2->3
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    head = cur.next;
                }
                cur = cur.next;
            }
        }
        return head;
    }
}
