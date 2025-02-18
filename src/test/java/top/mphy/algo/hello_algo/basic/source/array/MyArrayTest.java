package top.mphy.algo.hello_algo.basic.source.array;

import org.junit.jupiter.api.Test;
import top.mphy.algo.basic.source.array.MyArray;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {

    @Test
    void testArrayOperations() {
        MyArray<Integer> array = new MyArray<>(5, Integer.class);

        // 测试 set 和 get
        array.set(0, 10);
        array.set(1, 20);
        array.set(2, 30);
        array.set(3, 40);
        array.set(4, 50);
        assertEquals(10, array.get(0));
        assertEquals(50, array.get(4));

        // 测试 lenth
        assertEquals(5, array.lenth());

        // 测试 insert
        array = array.extend(1, Integer.class); // 先扩容
        array.insert(2, 99);
        assertEquals(99, array.get(2));

        // 测试 remove
        array.remove(2);
        assertNotEquals(99, array.get(2));

        // 测试 find
        assertEquals(3, array.find(40));
        assertEquals(-1, array.find(999)); // 不存在

        // 测试 traverse
        StringBuilder result = new StringBuilder();
        array.trarverse((value, index) -> result.append(value).append(","));
        assertTrue(result.toString().contains("10,20,30,40,50"));

        // 测试扩展
        MyArray<Integer> largerArray = array.extend(5, Integer.class);
        assertEquals(11, largerArray.lenth());
    }

    @Test
    void testEdgeCases() {
        MyArray<Integer> array = new MyArray<>(3, Integer.class);

        // 索引越界测试
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(5));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.set(5, 100));

        // 插入越界
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.insert(5, 99));

        // 删除越界
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(5));
    }
}

