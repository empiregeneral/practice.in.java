package cn.pintia.zjo.practice.problem1095;

import java.io.IOException;
import java.nio.CharBuffer;

public class FindHumbleNumber implements Readable, Generate<Integer> {
    private int count = 1;
    private int p2;
    private int p3;
    private int p5;
    private int p7;
    private int index = 0;
    private Integer[] humbleNumbers;
    private final int maxCapacity;

    public FindHumbleNumber() {
        this(5842);
    }

    public FindHumbleNumber(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        humbleNumbers = new Integer[this.maxCapacity];
        humbleNumbers[0] = 1;
        p2 = 1;
        p3 = 1;
        p5 = 1;
        p7 = 1;
    }

    private void dp() {
        Math.min(Math.min(p2, p3), Math.min(p5, p7));

    }

    @Override
    public Integer next() {
        return humbleNumbers[++index];
    }

    @Override
    public Integer[] createTable() {
        return humbleNumbers;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        return 0;
    }
}
