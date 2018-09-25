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


        ListNode head = null;

        //进位标识
        int carry = 0;

        //头结点
        if (l1.val + l2.val + carry < 10) {
            head = new ListNode(l1.val + l2.val);
            carry = 0;
        } else {
            head = new ListNode(l1.val + l2.val + carry - 10);
            carry = 1;
        }

        ListNode p = head;

        while (l1.next != null && l2.next != null) {
            ListNode node = null;
            if (l1.next.val + l2.next.val + carry < 10) {
                node = new ListNode(l1.next.val + l2.next.val + carry);
                carry = 0;
            } else {
                node = new ListNode(l1.next.val + l2.next.val + carry - 10);
                carry = 1;
            }
            p.next = node;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        //l1 比较长
        while (l1.next != null) {
            ListNode node = null;
            if (l1.next.val  + carry < 10) {
                node = new ListNode(l1.next.val + carry);
                carry = 0;
            } else {
                node = new ListNode(l1.next.val  + carry - 10);
                carry = 1;
            }
            p.next = node;
            p = p.next;
            l1 = l1.next;
        }


        //l2 比较长
        while (l2.next != null) {
            ListNode node = null;
            if (l2.next.val  + carry < 10) {
                node = new ListNode(l2.next.val + carry);
                carry = 0;
            } else {
                node = new ListNode(l2.next.val  + carry - 10);
                carry = 1;
            }
            p.next = node;
            p = p.next;
            l2 = l2.next;
        }

        //最后进位
        if ( carry == 1) {
            ListNode node = new ListNode(carry);
            p.next = node;
        }
        return head;

    }

}






