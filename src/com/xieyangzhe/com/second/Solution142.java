package com.xieyangzhe.com.second;

import com.xieyangzhe.com.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 28/3/20
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                return null;
            }
        } while (slow != fast);
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
