package com.xp.solutions._83_Remove_Duplicates_from_Sorted_List;

import com.xp.solutions._19_Remove_Nth_Node_From_End_of_List.Solution.ListNode;


/**
 * @author: yukong
 * @date: 2018/9/27 16:04
 * @description:
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (next != null) {
            if (pre.val == next.val) {
                while (next != null && pre.val == next.val) {
                    next = next.next;
                }
                if (next == null) {
                    break;
                }
            }
            pre.next = next;
            pre = next;
            next = next.next;
        }
        return head;
    }

}
