package top.mphy.algo.hello_algo.basic.source.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import top.mphy.algo.basic.source.linkedlist.LinkedList;
import top.mphy.algo.basic.source.linkedlist.ListNode;

public class LinkedListTest {
    @Test
    void testLinkedList() {
        LinkedList<String> linkedList1 = new LinkedList<>("a", "b", "c");
        assertEquals("abc", linkedList1.toString());
        LinkedList<String> linkedList2 = new LinkedList<>("a");
        assertEquals("a", linkedList2.toString());
        LinkedList<String> linkedList3 = new LinkedList<>("aa", "bb", "cc");
        assertEquals("aabbcc", linkedList3.toString());
        LinkedList<String> linkedList4 = new LinkedList<>();
        assertEquals("", linkedList4.toString());

        LinkedList<Integer> integerLinkedList = new LinkedList<>(0);
        ListNode<Integer> head = integerLinkedList.head;
        assertEquals(0, head.value);
        ListNode<Integer> n1 = new ListNode<>(1);
        ListNode<Integer> n2 = new ListNode<>(2);
        assertEquals(0, head.value);
    }
}
