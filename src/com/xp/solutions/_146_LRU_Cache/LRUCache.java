package com.xp.solutions._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukong
 * @date 2020/5/25 22:21
 */
public class LRUCache {
    class MyNode {
        int key;
        int value;
        MyNode pre;
        MyNode next;
        public MyNode() {}
        public MyNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
    int capacity;
    int size;
    MyNode head;
    MyNode tail;
    Map<Integer, MyNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new MyNode();

        tail = new MyNode();
        map = new HashMap<>();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        MyNode node = map.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        MyNode node = map.get(key);
        if(node == null) {
            node = new MyNode(key, value);
            map.put(key, node);
            moveToHead(node);
            ++size;
            if(size > capacity) {
                MyNode rmNode = removeTailNode();
                map.remove(rmNode.key);
                --size;
            }
        } else {
            node.value = value;

            moveToHead(node);
        }
    }

    private void moveToHead(MyNode node) {
        if(head.next == node) {
            return ;
        }
        head.next.pre = node;
        if(node.next != null ) {
            node.next.pre = node.pre;
        }
        if(node.pre != null) {
            node.pre.next = node.next;
        }
        node.next = head.next;

        head.next = node;
        node.pre= head;
    }

    private MyNode removeTailNode() {
        MyNode rmNode = tail.pre;
        rmNode.pre.next = rmNode.next;
        rmNode.next.pre = rmNode.pre;
        return rmNode;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(10,13);
        lruCache.put(3,17);
        lruCache.put(6,11);
        lruCache.put(10,5);
        lruCache.put(9,10);
        System.out.println(lruCache.get(13));
        lruCache.put(2,19);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(5,15);
        System.out.println(lruCache.get(8));
        lruCache.put(9,22);
        lruCache.put(5,5);
        lruCache.put(1,30);
        System.out.println(lruCache.get(11));
        lruCache.put(9,12);
        System.out.println(lruCache.get(7));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(9));
        lruCache.put(4,30);
        lruCache.put(9,3);
        System.out.println(lruCache.get(9));
        System.out.println(lruCache.get(10));

    }
}
