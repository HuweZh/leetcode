package com.huhusw;

import java.util.HashMap;

/**
 * 实现LRU
 */
public class LRU {
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(1, 4);
    }

    /**
     * 双向链表
     * 记录键值对的出现次序，越靠近head约新
     */
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //容量大小
    int cap;
    //当前元素个数
    int size;
    //虚拟头尾节点
    Node head, tail;
    //存储键值对，方便查找
    HashMap<Integer, Node> cache;

    LRU(int cap) {
        this.cap = cap;
        size = 0;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    //获取缓存中的元素
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        //提升这个键对应的使用情况
        remove(node);
        addHead(node);
        return node.value;
    }

    //放置键值对
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            cache.remove(key);
            remove(node);
        }
        if (size >= cap) {
            removeTail();
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        addHead(node);
    }

    private void addHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }

    private void removeTail() {
        Node prev = tail.prev;
        cache.remove(prev.key);
        remove(prev);
        size--;
    }
}
