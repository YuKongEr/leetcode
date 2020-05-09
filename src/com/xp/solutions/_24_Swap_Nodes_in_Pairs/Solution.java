package com.xp.solutions._24_Swap_Nodes_in_Pairs;

/**
 * @author: yukong
 * @date: 2018/9/25 14:55
 * @description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3. 说明:
 * <p>
 * 你的算法只能使用常数的额外空间。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode q = temp;
        ListNode p = head;
        ListNode r = null;
        while (p != null) {
            r = p.next;
            if (r == null) {
                break;
            }
            p.next = r.next;
            r.next = null;
            q.next = r;
            r.next = p;
            q = p;
            p = p.next;
        }
        return temp.next;
    }

    // 递归
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head.next;
        ListNode second = head;
        second.next = swapPairs(first.next);
        first.next = second;
        return first;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        //    l.next.next.next  = new ListNode(4);
        swapPairs(l);
        System.out.println(l.val);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }
}
