package top.mphy.algo.basic.core.linkedlist;

import java.util.List;

public class CircularLinkedList<E> {
    public ListNode<E> head;

    /**
     * 循环链表
     * @param values
     */
    @SafeVarargs
    public CircularLinkedList(E... values) {
        if (values.length == 0) return;
        head = new ListNode<>(values[0]);
        ListNode<E> cur = head;
        for (int i = 1; i < values.length; i++) {
            cur.next = new ListNode<>(values[i]);
            cur = cur.next;
        }
        cur.next = head;
    }
}
