package top.mphy.algo.hello_algo.chatper4_array_and_linkedlist.practice;

import java.util.ArrayList;
import java.util.List;

public class LCR_140 {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode cur = head;
        while (cnt-- > 0 && cur != null) {
            cur = cur.next;
        }
        ListNode res = head;
        while (cur != null) {
            res = res.next;
            cur = cur.next;
        }
        return res;
    }
}
