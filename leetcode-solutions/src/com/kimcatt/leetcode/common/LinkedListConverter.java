package com.kimcatt.leetcode.common;

import com.kimcatt.leetcode.common.ListNode;

import java.util.Arrays;

public class LinkedListConverter {

    public static ListNode parse(String str) {

        return null;
    }

    public static ListNode toListNode(int[] integers) {
        int len = integers != null ? integers.length : 0;
        if (len == 0) return null;
        ListNode head = null, pre = null, cur = null;
        for (int i = 0; i < len; i++) {
            cur = new ListNode(integers[i]);
            if (i == 0) {
                head = cur;
            }
            if (pre == null) {
                pre = cur;
            } else {
                pre.next = cur;
                pre = pre.next;
            }
        }
        return head;
    }

    public static String toString(ListNode head) {
        if (head == null) {
            return Arrays.toString(new int[0]);
        }
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val).append(",");
            head = head.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

}
