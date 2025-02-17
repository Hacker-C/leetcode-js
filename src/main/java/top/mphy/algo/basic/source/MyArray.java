package top.mphy.algo.basic.source;

import java.lang.reflect.Array;

public class MyArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public MyArray(int len, Class<T> clazz) {
        this.array = (T[]) Array.newInstance(clazz, len);
    }

    public T get(int index) {
        indexChecker(index);
        return array[index];
    }

    public void set(int index, T t) {
        indexChecker(index);
        array[index] = t;
    }

    public int lenth() {
        return array.length;
    }

    public void insert(int index, T t) {
        indexChecker(index);
        for (int i = lenth() - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = t;
    }

    public void remove(int index) {
        indexChecker(index);
        for (int i = index; i < lenth() - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    public int find(T target) {
        for (int i = 0; i < lenth(); i++) {
            if (get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    public void trarverse(ArrayConsumer<T> consumer) {
        for (int i = 0; i < lenth(); i++) {
            consumer.accept(array[i], i);
        }
    }

    public MyArray<T> extend(int enlarge, Class<T> clazz) {
        MyArray<T> newArray = new MyArray<>(lenth() + enlarge, clazz);
        trarverse((value, index) -> {
            newArray.set(index, value);
        });
        return newArray;
    }

    private void indexChecker(int index) {
        if (index < 0 || index >= lenth()) {
            throw new ArrayIndexOutOfBoundsException("out of index: " + index);
        }
    }
}


