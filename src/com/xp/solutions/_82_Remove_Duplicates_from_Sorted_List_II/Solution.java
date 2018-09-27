package com.xp.solutions._82_Remove_Duplicates_from_Sorted_List_II;

import com.xp.solutions._19_Remove_Nth_Node_From_End_of_List.Solution.ListNode;

/**
 * @author: yukong
 * @date: 2018/9/27 14:56
 * @description:
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Solution {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode q = temp;
        ListNode p = head;

        while (p != null) {
            if (p.next!= null &&p.val == p.next.val) {
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
            } else {
                q.next = p;
                q = p;
            }
            p = p.next;
        }
        q.next = p;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next  = new ListNode(2);
       l.next.next  = new ListNode(3);
        l.next.next.next  = new ListNode(3);
        l.next.next.next.next  = new ListNode(4);
        l.next.next.next.next.next  = new ListNode(4);
        l.next.next.next.next.next.next = new ListNode(5);
        deleteDuplicates(l);
    }
}
