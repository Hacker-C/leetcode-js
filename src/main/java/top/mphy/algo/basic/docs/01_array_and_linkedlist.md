# 1. 数组和链表

## 1. 数组

### 1.1 Java 数组常用操作

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

### 1.2 数组实现

- [MyArray](../core/array/MyArray.java)

## 2. 链表

### 2.1 链表实现

- [LinkedList](../core/linkedlist/LinkedList.java)
- [MyLinkedList](../core/linkedlist/MyLinkedList.java)
