package cn.pintia.zjo.practice.problem1962;

public interface Generate<T> {
    T next();
    T[] createTable();
}
