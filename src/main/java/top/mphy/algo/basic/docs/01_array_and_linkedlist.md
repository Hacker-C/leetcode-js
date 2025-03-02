# 数组和链表

## 1. 数组

### 1.1 Java 数组和列表常用操作

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

### 2.2 链表类型

- [单向链表](../core/linkedlist/MyLinkedList1.java)
- [循环链表](../core/linkedlist/CircularLinkedList.java)
- [双端链表](../core/linkedlist/DoublyLinkedList.java)

### 2.3 常见考题

常用方法：
- 设置多余头节点 `prev`
- 双指针

常用题型：
1. 逆转链表
2. 返回倒数第n个节点
3. 删除链表中指定值的节点
4. 在第n个位置插入节点

### 2.4 应用场景

1. 单向链表通常用于实现栈、队列、哈希表和图等数据结构。
   - 栈：当插入和删除操作都在链表的一端进行时，先进后出
   - 队列：当插入操作在链表的一端进行，先进先出
   - 哈希表：链式地址是解决哈希冲突的主流方案之一，在该方案中，所有冲突的元素都会被放到一个链表中。
   - 图：邻接表是表示图的一种常用方式，其中图的每个顶点都与一个链表相关联，链表中的每个元素都代表与该顶点相连的其他顶点。
2. 双向链表常用于需要快速查找前一个和后一个元素的场景。
- 高级数据结构：比如在红黑树、B 树中，我们需要访问节点的父节点，这可以通过在节点中保存一个指向父节点的引用来实现，类似于双向链表。
- 浏览器历史：在网页浏览器中，当用户点击前进或后退按钮时，浏览器需要知道用户访问过的前一个和后一个网页。双向链表的特性使得这种操作变得简单。
- LRU 算法：在缓存淘汰（LRU）算法中，我们需要快速找到最近最少使用的数据，以及支持快速添加和删除节点。这时候使用双向链表就非常合适。

- 3. 环形链表常用于需要周期性操作的场景，比如操作系统的资源调度。

- 时间片轮转调度算法：在操作系统中，时间片轮转调度算法是一种常见的 CPU 调度算法，它需要对一组进程进行循环。每个进程被赋予一个时间片，当时间片用完时，CPU 将切换到下一个进程。这种循环操作可以通过环形链表来实现。
- 数据缓冲区：在某些数据缓冲区的实现中，也可能会使用环形链表。比如在音频、视频播放器中，数据流可能会被分成多个缓冲块并放入一个环形链表，以便实现无缝播放。