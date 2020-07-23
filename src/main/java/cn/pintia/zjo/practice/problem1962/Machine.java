package cn.pintia.zjo.practice.problem1962;

import java.math.BigInteger;

public class Machine {
    public static BigInteger[] createFibTable(int scale) {
        BigInteger[] bigIntegers = new BigInteger[scale];
        bigIntegers[0] = new BigInteger("1");
        bigIntegers[1] = new BigInteger("2");

        for (int i = 2; i < scale; i++) {
            bigIntegers[i] = bigIntegers[i-1].add(bigIntegers[i-2]);
        }

        return bigIntegers;
    }
}
