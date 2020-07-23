package cn.pintia.zjo.practice.problem1962;

import java.math.BigInteger;

public class FibGenerate implements Generate<BigInteger> {
    private int n;
    private int index = 0;
    private BigInteger[] fibs;

    public FibGenerate(int n) {
        this.n = n;
        fibs = new BigInteger[n];
        fibs[0] = new BigInteger("1");
        fibs[1] = new BigInteger("2");
    }

    @Override
    public BigInteger next() {
        return this.fibs[++index];
    }

    @Override
    public BigInteger[] createTable() {
        for (int i = 2; i < n; i++) {
            fibs[i] = fibs[i-1].add(fibs[i-2]);
        }
        return fibs;
    }
}
