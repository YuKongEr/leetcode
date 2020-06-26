package com.xp.solutions.practice;

import com.xp.solutions.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1] 输出：[1, 2, 3] 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2] 输出：[1, 2] 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。 链表元素在[0, 20000]范围内。 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * @author yukong
 * @date 2020/6/26 11:19
 */
public class RemoveDuplicateNodeLCCI {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> vals = new HashSet<Integer>();
        ListNode pre = null;
        ListNode next = head;
        while (next != null) {
            if (vals.contains(next.val)) {
                pre.next = next.next;
            } else {
                vals.add(next.val);
                pre = next;
            }
            next = next.next;
        }
        return head;
    }
}
