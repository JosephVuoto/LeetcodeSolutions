package com.xieyangzhe.com.second;

import com.xieyangzhe.com.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 28/3/20
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                return false;
            }
        } while (slow != fast);
        return true;
    }
}
