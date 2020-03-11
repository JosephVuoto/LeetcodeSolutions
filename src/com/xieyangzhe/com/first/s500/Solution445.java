package com.xieyangzhe.com.first.s500;

import com.xieyangzhe.com.common.ListNode;

import java.util.Stack;

/**
 * @author Yangzhe Xie
 * @date 10/1/20
 */
public class Solution445 {
    //445. Add Two Numbers II
    //You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    //
    //You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    //
    //Follow up:
    //What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
    //
    //Example:
    //
    //Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    //Output: 7 -> 8 -> 0 -> 7
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        Stack<ListNode> s1 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        Stack<ListNode> s2 = new Stack<>();
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode resNode = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int n1 = s1.isEmpty() ? 0 : s1.pop().val;
            int n2 = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = n1 + n2 + carry;
            ListNode n = new ListNode(sum % 10);
            n.next = resNode;
            resNode = n;
            carry = sum / 10;
        }
        if (carry > 0) {
            ListNode n = new ListNode(carry);
            n.next = resNode;
            resNode = n;
        }
        return resNode;
    }
}
