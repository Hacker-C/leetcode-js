package top.mphy.algo.basic.core.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import top.mphy.algo.basic.core.linkedlist.MyLinkedList2;

public class MyMyLinkedList12Test {
    @Test
    void test1() {
        MyLinkedList2 myLinkedList2 = new MyLinkedList2();
        myLinkedList2.addAtHead(1);
        assertEquals("1", myLinkedList2.toString());
        myLinkedList2.addAtTail(3);
        assertEquals("1->3", myLinkedList2.toString());
        myLinkedList2.addAtIndex(1, 2); // 链表变为 1->2->3
        assertEquals("1->2->3", myLinkedList2.toString());
        assertEquals(2, myLinkedList2.get(1)); // 返回 2
        myLinkedList2.deleteAtIndex(1);    // 现在，链表变为 1->3
        assertEquals("1->3", myLinkedList2.toString());
        assertEquals(3, myLinkedList2.get(1)); // 返回 3
    }

    @Test
    void test2() {
        // ["MyLinkedList2","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        // [[],[1],[3],[1,2],[1],[0],[0]]
        MyLinkedList2 myLinkedList2 = new MyLinkedList2();
        myLinkedList2.addAtHead(1);
        myLinkedList2.addAtTail(3);
        myLinkedList2.addAtIndex(1,2 );
        myLinkedList2.get(1);
        myLinkedList2.deleteAtIndex(0);
        assertEquals(2, myLinkedList2.get(0));
    }
}
