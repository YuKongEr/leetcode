package com.xp.solutions.lru;

import java.util.HashMap;

/**
 * @author yukong
 * @date 2020/8/6 17:27
 */
public class LRUMap<K, V> {

    private HashMap<K, Node<K, V>> map;
    private DoubleList<K, V> cache;
    private int cap;

    public LRUMap(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList<K, V>();
    }

    public class Node<K, V> {

        private K key;
        private V value;
        private Node prev;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public class DoubleList<K, V> {

        private Node<K, V> head;
        private Node<K, V> tail;
        private int size;

        public DoubleList() {
            head = new Node("", "");
            tail = new Node("", "");
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node<K, V> node) {
            node.prev = tail.prev;
            tail.prev.next = node;
            node.next = tail;
            tail.prev = node;
            size++;
        }

        public void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node<K, V> removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node<K, V> first = head.next;
            remove(first);
            return first;
        }

        /**
         * 返回链表长度，时间 O(1)
         *
         * @return 返回长度
         */
        public int size() {
            return size;
        }
    }

    private void makeRecently(K key) {
        Node<K, V> node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void addRecently(K key, V value) {
        Node<K, V> node = new Node<K, V>(key, value);
        map.put(key, node);
        cache.addLast(node);
    }

    private void deleteKey(K key) {
        Node<K, V> node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node<K, V> first = cache.removeFirst();
        map.remove(first.key);
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            // 删除旧的数据
            deleteKey(key);
            // 新插入的数据为最近使用的数据
            addRecently(key, value);
            return;
        }

        if (cap == cache.size()) {
            // 删除最久未使用的元素
            removeLeastRecently();
        }
        // 添加为最近使用的元素
        addRecently(key, value);
    }

    public Node<K, V> get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        // 将该数据提升为最近使用的
        makeRecently(key);
        return map.get(key);
    }
}
