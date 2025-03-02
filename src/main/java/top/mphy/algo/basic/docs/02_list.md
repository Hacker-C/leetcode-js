# 列表

可以理解为动态数组，长度自动扩容，可以用数组和链表实现。关键实现要点：

- 定义 `size` 和 `capacity`，分别表示元素数量和列表容量
- `public MyList()` 用 `new Object[]{}` 实现，默认为空列表
- 扩容：列表底层的数组长度不够，需要扩容
- 缩容：删除了大部分元素时，列表底层的数组空出较多多余空间，可以触发缩容
- `toArray` 转数组方法用 `Arrays.copyOf(array, size, array.getClass())` 实现，且需要返回 `Object[]`， 因为存在类型擦除，即使返回泛型类型 `E[]`，调用也要用 `Object[]` 承接。

源码实现：[MyList](../core/list/MyList.java)
```java
package top.mphy.algo.basic.core.list;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 使用数组实现列表
 * @param <E>
 */
public class MyList<E> {

    private E[] array;

    /**
     * 元素数量
     */
    private int size = 0;

    /**
     * 容器容量
     */
    private int capacity = 0;

    /**
     * 列表扩容倍数
     */
    private static final int extendRatio = 2;


    /**
     * 泛型数组构造方法1：new Object()
     */
    @SuppressWarnings("unchecked")
    public MyList() {
        array = (E[]) new Object[]{};
    }

    /**
     * 泛型数组构造方法2：反射数组
     */
    @SuppressWarnings("unchecked")
    public MyList(Class<E> clazz) {
        array = (E[]) Array.newInstance(clazz, 0);
    }


    /* 获取列表长度（当前元素数量） */
    public int size() {
        return size;
    }

    /* 获取列表容量 */
    public int capacity() {
        return capacity;
    }

    /* 访问元素 */
    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    /* 更新元素 */
    public void set(int index, E num) {
        checkIndex(index);
        array[index] = num;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("索引越界");
        }
    }

    /* 在尾部添加元素 */
    public void add(E num) {
        if (size == capacity) {
            extendCapacity();
        }
        array[size] = num;
        size++;
    }

    /* 在中间插入元素 */
    public void insert(int index, E num) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (size + 1 > capacity) {
            extendCapacity();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = num;
        size++;
    }

    /* 删除元素 */
    public E remove(int index) {
        checkIndex(index);
        E res = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return res;
    }

    /* 列表扩容 */
    public void extendCapacity() {
        // 扩充数组
        if (capacity == 0) capacity = 1;
        array = Arrays.copyOf(array, capacity * extendRatio);
        capacity = array.length;
    }

    /* 将列表转换为数组 */
    public Object[] toArray() {
        return Arrays.copyOf(array, size, array.getClass());
    }
}


```