package com.xieyangzhe.com;

public class Main {

    public static void main(String[] args) {
        print(new Solution29().divide(-9, -2));
    }

    private static void print(Object obg) {
        System.out.println(obg);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head, nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
