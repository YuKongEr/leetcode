package com.xp.solutions._237_Delete_Node_in_a_Linked_List;

/**
 * @author yukong
 * @date 2020/3/27 22:52
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        int val;
       ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
