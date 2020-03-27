package com.xp.solutions._p20_reverse_linklist;


/**
 * @author yukong
 * @date 2020/3/27 21:48
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode next = null;
        ListNode curr = head;
        ListNode prev = head.next;
        while (prev != null) {
            curr.next = next;
            next = curr;
            dummyHead.next = curr;
            curr = prev;
            prev = prev.next;
        }
        curr.next = next;
        return curr;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode curr = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return curr;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
