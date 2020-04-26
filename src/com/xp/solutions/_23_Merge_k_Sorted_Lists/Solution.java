package com.xp.solutions._23_Merge_k_Sorted_Lists;

/**
 * @author: yukong
 * @date: 2018/9/25 14:55
 * @description:
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution {


     public static class ListNode {
          int val;
          ListNode next;
          public ListNode(int x) { val = x; }
     }

    public ListNode mergeKLists(ListNode[] lists) {
        return partiton(lists, 0, lists.length - 1);
    }

    private ListNode partiton(ListNode[] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        } else if(left < right) {
            int mid = left + (right - left) / 2;
            ListNode leftNode = partiton(lists, left, mid);
            ListNode rightNode = partiton(lists, mid + 1, right);
            return mergeList(leftNode, rightNode);
        } else {
            return null;
        }

    }

    private ListNode mergeList(ListNode left, ListNode right) {
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(left != null && right != null) {
            if(left.val < right.val) {
                curr.next = new ListNode(left.val);
                left = left.next;
            } else {
                curr.next = new ListNode(right.val);
                right = right.next;
            }
            curr = curr.next;
        }
        while(left != null) {
            curr.next = new ListNode(left.val);
            curr = curr.next;
            left = left.next;
        }
        while(right != null) {
            curr.next = new ListNode(right.val);
            curr = curr.next;
            right = right.next;
        }
        return head.next;
    }
}
