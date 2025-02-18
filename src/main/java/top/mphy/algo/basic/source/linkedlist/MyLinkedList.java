package top.mphy.algo.basic.source.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {
    private ListNode<Integer> head = null;
    public MyLinkedList() {
    }

    public int get(int index) {
        ListNode<Integer> cur = head;
        for (int i = 0; i < index; i++) {
            if (cur != null) {
                cur = cur.next;
            }
        }
        if (cur == null) return -1;
        return cur.value;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode<>(val);
            return;
        }
        ListNode<Integer> newHead = new ListNode<>(val);
        newHead.next = head;
        head = newHead;
    }

    public void addAtTail(int val) {
        ListNode<Integer> cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        if (cur == null) {
            head = new ListNode<>(val);
        } else {
            cur.next = new ListNode<>(val);
        }
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        };
        ListNode<Integer> cur = head;
        while (--index > 0) {
            if (cur != null) {
                cur = cur.next;
            }
        }
        if (cur != null) {
            ListNode<Integer> node = new ListNode<>(val);
            ListNode<Integer> temp = cur.next;
            cur.next = node;
            node.next = temp;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode<Integer> pre = new ListNode<>(null);
        ListNode<Integer> cur = head;
        pre.next = head;
        while (index-- > 0 && cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        if (pre != null && cur != null) {
            pre.next = cur.next;
            if (cur == head) {
                head = pre.next;
            }
        }
    }

    public String toString() {
        List<String> list = new ArrayList<>();
        ListNode<Integer> cur = head;
        while (cur != null) {
            list.add(cur.value.toString());
            cur = cur.next;
        }
        return String.join("->", list);
    }
}
