package com.xp.solutions._328_Odd_Even_Linked_List;

import com.xp.solutions.ListNode;

/**
 * @author yukong
 * @date 2020/3/27 22:54
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddCur = oddHead;
        ListNode evenCur = evenHead;
        while (evenCur.next != null && evenCur.next.next != null) {
            oddCur.next = evenCur.next;
            oddCur = oddCur.next;
            evenCur.next = oddCur.next;
            evenCur = evenCur.next;

        }
        if (evenCur.next != null) {
            oddCur.next = evenCur.next;
            evenCur.next = null;
            oddCur = oddCur.next;
        }
        oddCur.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        //    ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        //      l4.next = l5;
        new Solution().oddEvenList(l1);

    }
}
