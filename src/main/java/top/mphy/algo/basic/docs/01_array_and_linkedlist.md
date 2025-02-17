# 数组和链表

## Java 数组常用操作

1、直接初始化（静态初始化）
```java
int[] arr1 = {1, 2, 3, 4, 5};
String[] arr2 = {"A", "B", "C"};
double[] arr3 = {3.14, 2.71, 1.618};
```

2、new 关键字初始化
```java
int[] arr = new int[]{1, 2, 3, 4, 5};
String[] names = new String[]{"Alice", "Bob", "Charlie"};
```

3、预分配大小（默认初始化）
```java
int[] arr = new int[5];  // {0, 0, 0, 0, 0}
double[] dArr = new double[3];  // {0.0, 0.0, 0.0}
boolean[] boolArr = new boolean[2];  // {false, false}
String[] strArr = new String[4];  // {null, null, null, null}
```

4、填充默认值
```java
int[] arr = new int[5];
Arrays.fill(arr, 42);  // {42, 42, 42, 42, 42}  
```

5、for 循环动态填充
```java
int[] arr = new int[5];
for (int i = 0; i < arr.length; i++) {
    arr[i] = i * 2; // {0, 2, 4, 6, 8}
}
```

6、Stream 方式（Java 8+）
```java
import java.util.stream.IntStream;

// 生成一个 0~4 的数组
int[] arr = IntStream.range(0, 5).toArray(); // {0, 1, 2, 3, 4}

// 生成一个 5 个随机数的数组
int[] randomArr = IntStream.generate(() -> (int) (Math.random() * 100)).limit(5).toArray();
```

7、多维数组初始化
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

int[][] matrix = new int[2][3]; // {{0, 0, 0}, {0, 0, 0}}

int[][] jaggedArray = new int[3][];
jaggedArray[0] = new int[]{1, 2};
jaggedArray[1] = new int[]{3, 4, 5};
jaggedArray[2] = new int[]{6};
```

8、varargs 参数可变数组
```java
public static int[] genArray(int... nums) {
    return nums.clone();
}

printNumbers(1, 2, 3, 4, 5);  // [1, 2, 3, 4, 5]
```

9、List 转 Array
```java
List<Integer> list = Arrays.asList(1, 2, 3, 4);
// new Integer[0] 只是为了提供类型信息，JVM 会自动创建正确大小的数组
Integer[] array = list.toArray(new Integer[0]);
```

10、Array 转 List
```java
String[] strs0 = {"a", "b", "c"};
List<String> strList = Arrays.stream(strs0).toList();
```

11、Integer[] 转 int[]
```java
Integer[] integers = new Integer[] {1,2,3};
int[] ints = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
```

12、int[] 转 Integer[]
```java
int[] ints1 = {1,2,3};
Integer[] integers1 = Arrays.stream(ints1).boxed().toArray(Integer[]::new);
```

## Java 自定义数组实现

```java
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
```