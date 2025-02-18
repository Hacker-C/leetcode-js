package top.mphy.algo.basic.source.linkedlist;

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

    public String toString() {
        ListNode<T> cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.value);
            cur = cur.next;
        }
        return sb.toString();
    }
}
