package top.mphy.algo.basic.source;

@FunctionalInterface
public interface ArrayConsumer<T> {
    void accept(T value, int index);
}