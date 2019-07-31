package com.xieyangzhe.com;

public class Solution024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head.next;
        head.next = swapPairs(head.next.next);
        res.next = head;
        return res;
    }
}
