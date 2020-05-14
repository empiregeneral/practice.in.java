package cn.pintia.zjo.practice.test.problem1111;

public interface Generate<T> {
    T next();
    <T> T[] createTable();
}
