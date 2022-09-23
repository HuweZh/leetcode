package com.huhusw.middle;

import java.util.*;

public class M707 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);
    }
}

class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node tail;
    int n;

    public MyLinkedList() {
        n = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index >= n || index < 0) {
            return -1;
        }
        Node dummy = null;
        if (index <= n / 2) {
            dummy = head.next;
            while (index > 0) {
                index--;
                dummy = dummy.next;
            }
        } else {
            dummy = tail.prev;
            index = n - index - 1;
            while (index > 0) {
                index--;
                dummy = dummy.prev;
            }
        }
        return dummy.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
        n++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        n++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
        } else if (index == n) {
            addAtTail(val);
        } else if (index > n) {
            return;
        } else {
            Node dummy = null;
            if (index <= n / 2) {
                dummy = head.next;
                while (index > 0) {
                    index--;
                    dummy = dummy.next;
                }
            } else {
                dummy = tail.prev;
                index = n - index - 1;
                while (index > 0) {
                    index--;
                    dummy = dummy.prev;
                }
            }
            Node node = new Node(val);
            dummy.prev.next = node;
            node.prev = dummy.prev;
            node.next = dummy;
            dummy.prev = node;
            n++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= n) {
            return;
        }
        Node dummy = null;
        if (index <= n / 2) {
            dummy = head.next;
            while (index > 0) {
                index--;
                dummy = dummy.next;
            }
        } else {
            dummy = tail.prev;
            index = n - index - 1;
            while (index > 0) {
                index--;
                dummy = dummy.prev;
            }
        }
        dummy.prev.next = dummy.next;
        dummy.next.prev = dummy.prev;
        n--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */