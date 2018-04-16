package com.kimcatt.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public String toString() {
        return  LinkedListConverter.toString(this);
    }
}
