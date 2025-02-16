package top.mphy.algo.hello_algo.chatper4_array_and_linkedlist.practice;


import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_LCR139 {
    /**
     * 双指针移动法
     * @param actions
     * @return
     */
    public int[] trainingPlan(int[] actions) {
        for (int i = 0, j = 0; j < actions.length; j++) {
            if ((actions[j] & 1) == 1) {
                swap(actions, i++,j);
            }
        }
        System.out.println(Arrays.toString(actions));
        return actions;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(1 & 1);
        System.out.println(2 & 1);
        System.out.println(3 & 1);
    }
}
