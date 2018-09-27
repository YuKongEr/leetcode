package com.xp.solutions._86_Partition_List;

import com.xp.solutions._19_Remove_Nth_Node_From_End_of_List.Solution.ListNode;


/**
 * @author: yukong
 * @date: 2018/9/27 16:27
 * @description:
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Solution {
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode minHead = new ListNode(-1);
        ListNode min = new ListNode(-1);
        ListNode maxHead = new ListNode(-1);
        ListNode max = new ListNode(-1);
        ListNode curr = head;
        Boolean minFirst = true;
        Boolean maxFirst = true;
        while (curr != null) {
            if (curr.val < x) {
                min.next = curr;
                min = min.next;
                if (minFirst) {
                    minHead.next = min;
                    minFirst = false;
                }

            } else {
                max.next = curr;
                max = max.next;
                if (maxFirst) {
                    maxHead.next = max;
                    maxFirst = false;
                }

            }
            curr = curr.next;
        }
        min.next = null;
        max.next = null;
        if (minHead.next != null) {
           min.next = maxHead.next;
        } else {
            minHead = maxHead;
        }
        return minHead.next;
    }


    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next  = new ListNode(4);
        l.next.next  = new ListNode(3);
        l.next.next.next  = new ListNode(2);
        l.next.next.next.next  = new ListNode(5);
        l.next.next.next.next.next  = new ListNode(2);
        partition(l,3);
    }
}
