package com.kimcatt.leetcode.no2;

import com.kimcatt.leetcode.common.LinkedListConverter;
import com.kimcatt.leetcode.common.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    /**
     * 递归方式求解
     *
     * @param l1
     * @param l2
     * @param carry
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry > 0 && carry < 10)
                return new ListNode(carry);
            else
                return null;
        }
        if (l1 == null) {
            return addTwoNumbers(l2, l1, carry);
        }
        if (l2 == null && carry == 0) {
            return l1;
        }
        int val;
        val = l1.val + (l2 == null ? 0 : l2.val) + carry;
        carry = val / 10;
        val = val % 10;
        ListNode cur = new ListNode(val);
        cur.next = addTwoNumbers(l1.next, l2 == null ? null : l2.next, carry);
        return cur;
    }

    /**
     * 循环方式求解
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        ListNode cur = null, dummy = new ListNode(0), pre = dummy;
        int val = 0, carry = 0;
        while (l1 != null && l2 != null) {
            val = l1.val + l2.val + carry;
            carry = val / 10;
            val = val % 10;
            cur = new ListNode(val);
            pre.next = cur;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode t = l1 == null ? l2 : l1;
        while (t != null) {
            if (carry == 0) {
                pre.next = t;
                return dummy.next;
            }
            val = t.val + carry;
            carry = val / 10;
            val = val % 10;
            cur = new ListNode(val);
            pre.next = cur;
            pre = pre.next;
            t = t.next;
        }
        if (carry > 0) {
            cur = new ListNode(carry);
            pre.next = cur;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {2, 4, 3};
        int[] b = {8};
        ListNode headA = LinkedListConverter.toListNode(a);
        ListNode headB = LinkedListConverter.toListNode(b);
        System.out.println(LinkedListConverter.toString(headA));
        System.out.println(LinkedListConverter.toString(headB));
        System.out.println(LinkedListConverter.toString(solution.addTwoNumbers(headA, headB)));
    }


}
