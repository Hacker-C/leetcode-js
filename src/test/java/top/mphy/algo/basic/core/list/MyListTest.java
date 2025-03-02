package top.mphy.algo.basic.core.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {

    @Test
    public void testMyList() {
        // 测试构造函数
        MyList<Integer> list = new MyList<>();
        assertEquals(0, list.size()); // 初始大小应为 0
        assertEquals(0, list.capacity()); // 初始容量应为 0

        // 测试添加元素
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size()); // 添加 3 个元素后，大小应为 3
        assertEquals(4, list.capacity()); // 容量应为 4


        // 测试访问元素
        assertEquals(10, list.get(0)); // 第一个元素应为 10
        assertEquals(20, list.get(1)); // 第二个元素应为 20
        assertEquals(30, list.get(2)); // 第三个元素应为 30

        // 测试更新元素
        list.set(1, 25);
        assertEquals(25, list.get(1)); // 更新后，第二个元素应为 25

        // 测试插入元素
        list.insert(1, 15);
        assertEquals(4, list.size()); // 插入后，大小应为 4
        assertEquals(15, list.get(1)); // 插入的元素应为 15
        assertEquals(25, list.get(2)); // 原来的第二个元素应后移

        // 测试删除元素
        int removed = list.remove(1);
        assertEquals(15, removed); // 删除的元素应为 15
        assertEquals(3, list.size()); // 删除后，大小应为 3
        assertEquals(25, list.get(1)); // 删除后，第二个元素应为 25

        // 测试边界情况：删除最后一个元素
        removed = list.remove(list.size() - 1);
        assertEquals(30, removed); // 删除的元素应为 30
        assertEquals(2, list.size()); // 删除后，大小应为 2

        // 测试边界情况：删除第一个元素
        removed = list.remove(0);
        assertEquals(10, removed); // 删除的元素应为 10
        assertEquals(1, list.size()); // 删除后，大小应为 1

        // 测试边界情况：删除唯一剩余的元素
        removed = list.remove(0);
        assertEquals(25, removed); // 删除的元素应为 25
        assertEquals(0, list.size()); // 删除后，大小应为 0

        // 测试边界情况：在空列表中插入元素
        list.insert(0, 5);
        assertEquals(1, list.size()); // 插入后，大小应为 1
        assertEquals(5, list.get(0)); // 插入的元素应为 5

        // 测试边界情况：在列表末尾插入元素
        list.insert(list.size(), 10);
        assertEquals(2, list.size()); // 插入后，大小应为 2
        assertEquals(10, list.get(1)); // 插入的元素应为 10

        // 测试边界情况：在列表开头插入元素
        list.insert(0, 0);
        assertEquals(3, list.size()); // 插入后，大小应为 3
        assertEquals(0, list.get(0)); // 插入的元素应为 0

        // 测试边界情况：访问空列表（应抛出异常）
        MyList<Integer> emptyList = new MyList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(0));

        // 测试边界情况：访问超出范围的索引（应抛出异常）
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));

        // 测试边界情况：更新超出范围的索引（应抛出异常）
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, 100));

        // 测试边界情况：插入到超出范围的索引（应抛出异常）
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(4, 100));

        // 测试边界情况：删除超出范围的索引（应抛出异常）
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));

        // 测试转换为数组
        Object[] array = list.toArray();
        assertArrayEquals(new Integer[]{0, 5, 10}, array); // 转换后的数组应与列表内容一致

        // 测试扩容
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertTrue(list.capacity() >= 103); // 容量应至少为 103
        assertEquals(103, list.size()); // 大小应为 103
    }
}
