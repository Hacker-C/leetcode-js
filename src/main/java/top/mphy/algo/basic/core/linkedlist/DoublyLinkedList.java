package top.mphy.algo.basic.core.linkedlist;

/**
 * 双向链表
 *
 * @param <E> 值类型
 */
public class DoublyLinkedList<E> {
    public DoublyListNode<E> head;

    @SafeVarargs
    public DoublyLinkedList(E... values) {
        head = new DoublyListNode<>(values[0]);
        DoublyListNode<E> cur = head;
        for (int i = 1; i < values.length; i++) {
            DoublyListNode<E> newNode = new DoublyListNode<>(values[i]);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
    }
}
