package com.xp.solutions._21_Merge_Two_Sorted_Lists;

/**
 * @author: yukong
 * @date: 2018/9/25 14:55
 * @description:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Solution {


     public static class ListNode {
         int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 存在有一条或者多条空链表的情况 可以直接返回
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        // 定义头
        ListNode head = new ListNode(-1);

        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                head.next = p1;
                p1 = p1.next;
            } else {
                head.next = p2;
                p2 = p2.next;
            }
            head = head.next;
        }

        while (p1 != null) {
            head.next = p1;
            p1 = p1.next;
            head = head.next;
        }

        while (p2 != null) {
            head.next = p2;
            p2 = p2.next;
            head = head.next;
        }
        return p.next;
    }
    // 递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

}
