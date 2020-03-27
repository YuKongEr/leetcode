package com.xp.solutions._234_Palindrome_Linked_List;

/**
 * @author yukong
 * @date 2020/3/27 22:33
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode firstHalf = head;
        firstHalf = firstHalfEnd(firstHalf);
        ListNode endHalf = reverseList(firstHalf.next);
        firstHalf.next = null;
        firstHalf = head;
        while (endHalf != null && firstHalf != null) {
            if (endHalf.val != firstHalf.val) {
                return false;
            }
            endHalf = endHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }


    private ListNode firstHalfEnd(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }

    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode curr = head;
        ListNode prev = head.next;
        while (prev != null) {
            curr.next = next;
            next = curr;
            curr = prev;
            prev = prev.next;
        }
        curr.next = next;
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
