package com.xp.solutions._138_Copy_List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukong
 * @date 2020/3/26 09:34
 */
public class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Map<Node, Node> oldToNewMap = new HashMap<>();
        while (curr != null) {
            oldToNewMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        Node next = null;
         while (curr != null) {
            next = oldToNewMap.get(curr);
            next.next = oldToNewMap.get(curr.next);
            next.random = oldToNewMap.get(curr.random);
            curr = curr.next;
        }
        return oldToNewMap.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
