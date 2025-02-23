package top.mphy.algo.basic.core.linkedlist;

/**
 * 双向链表节点类型
 * @param <E> 值类型
 */
public class DoublyListNode<E> {
    public E value;

    public DoublyListNode<E> prev;

    public DoublyListNode<E> next;

    public DoublyListNode(E value) {
        this.value = value;
    }

    public DoublyListNode(E value, DoublyListNode<E> prev, DoublyListNode<E> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
