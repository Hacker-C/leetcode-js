package top.mphy.algo.hello_algo.basic.source.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import top.mphy.algo.basic.core.linkedlist.LinkedList;
import top.mphy.algo.basic.core.linkedlist.ListNode;

public class LinkedListTest {
    @Test
    void testLinkedList() {
        LinkedList<String> linkedList1 = new LinkedList<>("a", "b", "c");
        assertEquals("a->b->c", linkedList1.toString());
        LinkedList<String> linkedList2 = new LinkedList<>("a");
        assertEquals("a", linkedList2.toString());
        LinkedList<String> linkedList3 = new LinkedList<>("aa", "bb", "cc");
        assertEquals("aa->bb->cc", linkedList3.toString());
        LinkedList<String> linkedList4 = new LinkedList<>();
        assertEquals("", linkedList4.toString());

        LinkedList<Integer> linkedList = new LinkedList<>(0);
        ListNode<Integer> head = linkedList.head;
        assertEquals(0, head.value);
        ListNode<Integer> n1 = new ListNode<>(1);
        ListNode<Integer> n2 = new ListNode<>(2);
        head.next = n1;
        assertEquals("0->1", linkedList.toString());
        n1.next = n2;
        assertEquals("0->1->2", linkedList.toString());
        assertEquals(0, head.value);


        linkedList.insert(n1, 3);
        assertEquals("0->1->3->2", linkedList.toString());
        linkedList.insert(n1, 4);
        linkedList.insert(n2, 5);
        linkedList.insert(head, -1);
        assertEquals("0->-1->1->4->3->2->5", linkedList.toString());

        linkedList.delete(head);
        assertEquals("-1->1->4->3->2->5", linkedList.toString());
        linkedList.delete(n1);
        linkedList.delete(n1);
        linkedList.delete(n2);
        assertEquals("-1->4->3->5", linkedList.toString());

        ListNode<Integer> n6 = new ListNode<>(6);
        linkedList.insert(linkedList.head, n6);
        linkedList.insert(n6, 7);
        assertEquals("-1->6->7->4->3->5", linkedList.toString());

        ListNode<Integer> n7 = linkedList.find(7);
        assertEquals(7, n7.value);

        ListNode<Integer> n99 = linkedList.find(99);
        assertNull(n99);
    }
}
