package top.mphy.algo.basic.source.array;

@FunctionalInterface
public interface ArrayConsumer<T> {
    void accept(T value, int index);
}