package top.mphy.algo.basic.core.array;

@FunctionalInterface
public interface ArrayConsumer<T> {
    void accept(T value, int index);
}