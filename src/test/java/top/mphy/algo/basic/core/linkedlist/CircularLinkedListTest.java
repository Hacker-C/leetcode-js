package top.mphy.algo.basic.core.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import top.mphy.algo.basic.core.linkedlist.CircularLinkedList;
import top.mphy.algo.basic.core.linkedlist.ListNode;

import java.util.concurrent.TimeUnit;

public class CircularLinkedListTest {
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void test1() {
        CircularLinkedList<String> c1 = new CircularLinkedList<>("a", "b", "c");
        ListNode<String> cur = c1.head;
        boolean ok = false;
        while (cur != null) {
            cur = cur.next;
            if (cur == c1.head) {
                ok = true;
                break;
            }
        }
        assertTrue(ok);
    }
}
