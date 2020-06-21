package com.xp.solutions._2_Add_Two_Numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: yukong
 * Date: 2018-01-15
 * Time: 14:42
 */

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        ListNode ll1 = l1;
        ListNode ll2 = l2;
        int carry = 0;
        while(ll1 != null || ll2 != null) {
            int val = 0;
            if (ll1 != null) {
                val += ll1.val;
                ll1 = ll1.next;

            }
            if (ll2 != null) {
                val += ll2.val;
                ll2 = ll2.next;
            }
            val += carry;
            carry = val / 10;
            val = val % 10;
            head.next = new ListNode(val);
            head = head.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}






