package com.xp.solutions._703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;

/**
 * @author yukong
 * @date 2019-04-07 21:37
 */
public class KthLargest {
    final private PriorityQueue<Integer> heap;
    final private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(heap.size() < k) {
            heap.offer(val);
        } else if(heap.peek() < val) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }

}
