package com.xieyangzhe.third;

import com.xieyangzhe.common.ListNode;

/**
 * @author Yangzhe Xie
 * @date 4/7/20
 */
public class Solution206 {
    //206. 反转链表
    //反转一个单链表。
    //
    //示例:
    //
    //输入: 1->2->3->4->5->NULL
    //输出: 5->4->3->2->1->NULL
    //进阶:
    //你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next;
        head.next = null;
        ListNode newHead = reverseList(tmp);
        tmp.next = head;
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
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
        ListNode node = ListNode.fromList(1,2,3,4,5);
        System.out.println(new Solution206().reverseList1(node));
    }
}
