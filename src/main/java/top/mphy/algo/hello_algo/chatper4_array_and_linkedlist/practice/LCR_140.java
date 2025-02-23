package top.mphy.algo.hello_algo.chatper4_array_and_linkedlist.practice;

import java.util.ArrayList;
import java.util.List;

public class LCR_140 {
    public ListNode trainingPlan1(ListNode head, int cnt) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        return list.get(list.size() - cnt);
    }

    public ListNode trainingPlan2(ListNode head, int cnt) {
        ListNode pre = head, cur = head;
        for (int i = 0; i < cnt; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return pre;
    }
}
