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
        return partion(lists, 0, lists.length - 1);
    }

    public  ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return mergeTwoLists(l1,l2);
        }else
            return null;
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
        ListNode head = null;

        // 选择值叫小的一条链表的首节点作为头
        if (p1.val < p2.val) {
            head = p1;
            p1 = p1.next;
        } else {
            head = p2;
            p2 = p2.next;
        }
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
        return p;
    }
}
