package top.mphy.algo.hello_algo.basic.core.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import top.mphy.algo.basic.core.linkedlist.MyLinkedList1;
import top.mphy.algo.basic.core.linkedlist.ListNode;

public class MyLinkedList1Test {
    @Test
    void testLinkedList() {
        MyLinkedList1<String> myLinkedList11 = new MyLinkedList1<>("a", "b", "c");
        assertEquals("a->b->c", myLinkedList11.toString());
        MyLinkedList1<String> myLinkedList12 = new MyLinkedList1<>("a");
        assertEquals("a", myLinkedList12.toString());
        MyLinkedList1<String> myLinkedList13 = new MyLinkedList1<>("aa", "bb", "cc");
        assertEquals("aa->bb->cc", myLinkedList13.toString());
        MyLinkedList1<String> myLinkedList14 = new MyLinkedList1<>();
        assertEquals("", myLinkedList14.toString());

        MyLinkedList1<Integer> myLinkedList1 = new MyLinkedList1<>(0);
        ListNode<Integer> head = myLinkedList1.head;
        assertEquals(0, head.value);
        ListNode<Integer> n1 = new ListNode<>(1);
        ListNode<Integer> n2 = new ListNode<>(2);
        head.next = n1;
        assertEquals("0->1", myLinkedList1.toString());
        n1.next = n2;
        assertEquals("0->1->2", myLinkedList1.toString());
        assertEquals(0, head.value);


        myLinkedList1.insert(n1, 3);
        assertEquals("0->1->3->2", myLinkedList1.toString());
        myLinkedList1.insert(n1, 4);
        myLinkedList1.insert(n2, 5);
        myLinkedList1.insert(head, -1);
        assertEquals("0->-1->1->4->3->2->5", myLinkedList1.toString());

        myLinkedList1.delete(head);
        assertEquals("-1->1->4->3->2->5", myLinkedList1.toString());
        myLinkedList1.delete(n1);
        myLinkedList1.delete(n1);
        myLinkedList1.delete(n2);
        assertEquals("-1->4->3->5", myLinkedList1.toString());

        ListNode<Integer> n6 = new ListNode<>(6);
        myLinkedList1.insert(myLinkedList1.head, n6);
        myLinkedList1.insert(n6, 7);
        assertEquals("-1->6->7->4->3->5", myLinkedList1.toString());

        ListNode<Integer> n7 = myLinkedList1.find(7);
        assertEquals(7, n7.value);

        ListNode<Integer> n99 = myLinkedList1.find(99);
        assertNull(n99);
    }
}
