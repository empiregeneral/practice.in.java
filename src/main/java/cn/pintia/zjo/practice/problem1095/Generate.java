package cn.pintia.zjo.practice.problem1095;

public interface Generate<T> {
    T next();
    T[] createTable();
}
