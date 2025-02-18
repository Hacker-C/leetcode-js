package top.mphy.algo.hello_algo.basic.source.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import top.mphy.algo.basic.source.linkedlist.MyLinkedList;

public class MyLinkedListTest {
    @Test
    void test1() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        assertEquals("1", myLinkedList.toString());
        myLinkedList.addAtTail(3);
        assertEquals("1->3", myLinkedList.toString());
        myLinkedList.addAtIndex(1, 2); // 链表变为 1->2->3
        assertEquals("1->2->3", myLinkedList.toString());
        assertEquals(2, myLinkedList.get(1)); // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        assertEquals("1->3", myLinkedList.toString());
        assertEquals(3, myLinkedList.get(1)); // 返回 3
    }

    @Test
    void test2() {
        // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        // [[],[1],[3],[1,2],[1],[0],[0]]
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2 );
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(0);
        assertEquals(2, myLinkedList.get(0));
    }
}
