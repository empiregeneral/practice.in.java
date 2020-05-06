package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.Card;

public interface Generate<T> {
    T next();
    <T> T[] createTable();
}
