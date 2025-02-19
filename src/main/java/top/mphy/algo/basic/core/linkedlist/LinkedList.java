package top.mphy.algo.basic.core.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {

    public ListNode<T> head;

    @SafeVarargs
    public LinkedList(T...values) {
        if (values.length == 0) {
            head = null;
            return;
        }
        ListNode<T> firstNode = new ListNode<>(values[0]);
        head = firstNode;
        for (int i = 1; i < values.length; i++) {
            T value = values[i];
            ListNode<T> node = new ListNode<>(value);
            firstNode.next = node;
            firstNode = node;
        }
    }

    public void insert(ListNode<T> node, T value) {
        ListNode<T> next = node.next;
        ListNode<T> node1 = new ListNode<>(value);
        node.next = node1;
        node1.next = next;
    }

    /**
     *在 node0 后插入 node1
     * @param node0
     * @param node1
     */
    public void insert(ListNode<T> node0, ListNode<T> node1) {
        ListNode<T> next = node0.next;
        node0.next = node1;
        node1.next = next;
    }

    public void delete(ListNode<T> node) {
        if (node == null) return;
        if (node == head) {
            head = head.next;
        }
        ListNode<T> pre = new ListNode<>(null);
        pre.next = head;
        ListNode<T> cur = head;
        while (cur != null) {
            if (cur == node) {
                break;
            }
            cur = cur.next;
            pre = pre.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
    }

    public String toString() {
        ListNode<T> cur = head;
        List<String> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.value.toString());
            cur = cur.next;
        }
        return String.join("->", list);
    }
}
