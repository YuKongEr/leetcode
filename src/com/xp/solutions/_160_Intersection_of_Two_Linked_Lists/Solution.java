package com.xp.solutions._160_Intersection_of_Two_Linked_Lists;

/**
 * 160. 相交链表 编写一个程序，找到两个单链表相交的起始节点。
 *
 * @author yukong
 * @date 2020/3/27 21:17
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        int lengthA = 0, lengthB = 0;
        while (currA != null) {
            currA = currA.next;
            lengthA++;
        }
        while (currB != null) {
            currB = currB.next;
            lengthB++;
        }
        currA = headA;
        currB = headB;
        // 求出长度差 长的先走
        int diff = lengthA - lengthB;
        if (diff > 0) {
            while (diff > 0) {
                currA = currA.next;
                diff--;
            }
        } else {
            while (diff < 0) {
                currB = currB.next;
                diff++;
            }
        }
        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(2);
        ListNode headB1 = new ListNode(3);
        ListNode c = new ListNode(3);
        c.next = new ListNode(4);
        headA.next = c;
        headB.next = headB1;
        headB1.next = c;
        System.out.println(new Solution().getIntersectionNode(headA, headB));
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
