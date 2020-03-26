package com.xp.solutions._142_Linked_List_Cycle_II;

import java.util.LinkedList;

/**
 * 142. 环形链表 II 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1 输出：tail connects to node index 1 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * @author yukong
 * @date 2020/3/26 21:40
 */
public class Solution {
    /**
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        ListNode low = hasCycle(curr);
        // 不相交
        if (low == null) {
            return null;
        }
        // x = R - y
        curr = head;
        while (curr != low) {
            low = low.next;
            curr = curr.next;
        }
        return low;
    }

    private ListNode hasCycle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return low;
            }
        }
        return null;
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
