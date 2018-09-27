package com.xp.solutions._25_Reverse_Nodes_in_k_Group;

import com.xp.solutions._19_Remove_Nth_Node_From_End_of_List.Solution.ListNode;

/**
 * @author: yukong
 * @date: 2018/9/26 16:09
 * @description:
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution {

    /**
     * 先 分组 然后每组倒序
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode curr = head;
        ListNode pre = listNode;
        Boolean isFirst = true;
        int i = 0;
        while (curr != null) {
            i++;
            if (i % k ==0) {
                // 判断是否是第一次 倒序 如果是 则需要定位头
                if (isFirst) {
                    pre = reverse(listNode, curr.next);
                    isFirst = false;
                } else{
                    pre = reverse(pre, curr.next);
                }
                curr = pre.next;
            } else {
                curr = curr.next;
            }
        }

        return listNode.next;
    }

    /**
     * 分段反转
     * pre 为反转段前节点
     * next 为反正转断后节点
     * @param pre
     * @param next
     * @return
     */
    public static ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode curr = last.next;
        while (curr != next) {
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;

        }
        return last;

    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next  = new ListNode(2);
        l.next.next  = new ListNode(3);
        l.next.next.next  = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        reverseKGroup(l,2);
    }

}
