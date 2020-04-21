package cn.pintia.zjo.practice.problem1095;

import benchmark.JvmRuntimeAspect;
import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;

import java.io.IOException;
import java.nio.CharBuffer;

public class HumbleNumberGenerate implements Readable, Generate<Integer> {
    private int count = 1;
    private int p2;
    private int p3;
    private int p5;
    private int p7;
    private int index = 0;
    private Integer[] humbleNumbers;
    private final int maxCapacity;

    public HumbleNumberGenerate() {
        this(5842);
    }

    public HumbleNumberGenerate(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        humbleNumbers = new Integer[this.maxCapacity];
        humbleNumbers[index] = 1;
        p2 = 0;
        p3 = 0;
        p5 = 0;
        p7 = 0;
    }

    private void dp() {
        humbleNumbers[++index] = Math.min(Math.min(humbleNumbers[p2] * 2, humbleNumbers[p3] * 3), Math.min(humbleNumbers[p5] * 5, humbleNumbers[p7] * 7));
        if (humbleNumbers[index] == humbleNumbers[p2] * 2) {
            p2++;
        }
        if (humbleNumbers[index] == humbleNumbers[p3] * 3) {
            p3++;
        }
        if (humbleNumbers[index] == humbleNumbers[p5] * 5) {
            p5++;
        }
        if (humbleNumbers[index] == humbleNumbers[p7] * 7) {
            p7++;
        }
    }

    @Override
    public Integer next() {
        dp();
        return humbleNumbers[index];
    }

    @Override
    public Integer[] createTable() {
        while(hasNext()) {
            next();
        }
        return humbleNumbers;
    }

    public boolean hasNext() {
        return (index < maxCapacity - 1) ;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        return 0;
    }

    public static void main(String[] args) {
        Generate<Integer> generator = ProxyUtil.proxy(new HumbleNumberGenerate(), JvmRuntimeAspect.class);
        Integer[] arr = generator.createTable();
        System.out.println(arr[5841]);
    }
}
