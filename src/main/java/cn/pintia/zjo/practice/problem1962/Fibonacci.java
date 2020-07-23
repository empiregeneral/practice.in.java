package cn.pintia.zjo.practice.problem1962;

import cn.pintia.zjo.practice.problem1526.BigNumber;

import java.util.Iterator;

public class Fibonacci extends FibGenerate implements Iterable<BigNumber> {
    public Fibonacci(int n) {
        super(n);
    }

    @Override
    public Iterator<BigNumber> iterator() {
        return null;
    }
}
