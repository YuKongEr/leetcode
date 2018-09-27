package com.xp.solutions._92_Reverse_Linked_List_II;

import com.xp.solutions._19_Remove_Nth_Node_From_End_of_List.Solution.ListNode;


/**
 * @author: yukong
 * @date: 2018/9/27 17:14
 * @description:
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Solution {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m-n == 0) {
            return head;
        }
        int count = 0;
        n += 2;
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = null;
        ListNode next = null;
        ListNode curr =  h;
        while (count++ <= n){
            if (count == m) {
                pre = curr;
            }
            if (count == n) {
                next = curr;
                break;
            }
            curr = curr.next;
        }
        curr = pre.next;
        ListNode node = null;
        ListNode p = next;
        while ( curr != next) {
            pre.next = curr;
            node = curr.next;
            curr.next = p;
            p = curr;
            curr = node;
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next  = new ListNode(2);
        l.next.next  = new ListNode(3);
        l.next.next.next  = new ListNode(4);
        l.next.next.next.next  = new ListNode(5);
        reverseBetween(l,2,4);
    }
}
