package com.xp.solutions._61_Rotate_List;

import com.xp.solutions._19_Remove_Nth_Node_From_End_of_List.Solution.ListNode;

import java.util.List;

/**
 * @author: yukong
 * @date: 2018/9/27 14:26
 * @description:
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Solution {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }

        ListNode h = head;
        int count = 1;
        while (h.next != null) {
            h = h.next;
            count++;
        }
        // 旋转是链表的长度的整数倍 直接返回头
        k = k % count;
        if (k == 0) {
            return head;
        }
        k = count - k;
        h.next = head;
        ListNode q = h;
        while (k-- > 0) {
            q = q.next;
        }
        head = q.next;
        q.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next  = new ListNode(2);
        l.next.next  = new ListNode(3);
        l.next.next.next  = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        rotateRight(l, 2);
    }
}
